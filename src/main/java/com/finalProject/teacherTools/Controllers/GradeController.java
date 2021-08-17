package com.finalProject.teacherTools.Controllers;

import com.finalProject.teacherTools.Models.Assignment;
import com.finalProject.teacherTools.Models.Grade;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.AssignmentRepo;
import com.finalProject.teacherTools.Repos.GradeRepo;
import com.finalProject.teacherTools.Repos.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradeController {
    private GradeRepo gradeRepo;
    private StudentRepo studentRepo;
    private AssignmentRepo assignmentRepo;

    public GradeController(GradeRepo gradeRepo, StudentRepo studentRepo, AssignmentRepo assignmentRepo) {
        this.gradeRepo = gradeRepo;
        this.studentRepo = studentRepo;
        this.assignmentRepo = assignmentRepo;
    }

    @PostMapping("/assignment/{id}")
    public String addGradeOnAssignment(@PathVariable("id") Long id, double grade, double maximumGrade, Long student){
        Assignment assignmentToAddGrade = assignmentRepo.findById(id).get();
        Student studentToAddGrade = studentRepo.findById(student).get();
        Grade gradeToAdd = new Grade(assignmentToAddGrade, grade, maximumGrade);
        gradeToAdd.addStudentToGrade(studentToAddGrade);
        gradeRepo.save(gradeToAdd);

        return "redirect:/assignment" + "?id=" + assignmentToAddGrade.getId();
    }
}

