package com.finalProject.teacherTools.Controllers;

import com.finalProject.teacherTools.Models.Assignment;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.AssignmentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class AssignmentController {
    private AssignmentRepo assignmentRepo;

    public AssignmentController(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    
    @GetMapping("/assignment")
    public String displayAssignmentPage(@RequestParam("id") Long id, Model model){
        Assignment assignment = assignmentRepo.findById(id).get();
        model.addAttribute("individualAssignment", assignment);
        return "single-assignment-template";
    }

    @PostMapping("/assignment/deleteassignment/{id}")
    public String deleteAssignment (@PathVariable("id")Long id) {
        Assignment assignmentToDelete = assignmentRepo.findById(id).get();
        Collection<Student> studentsAssigned = assignmentToDelete.getStudents();
        for(Student student : studentsAssigned) {
            student.deleteAssignment(assignmentToDelete);
        }
        assignmentRepo.deleteById(id);

        return "redirect:/";
    }

}
