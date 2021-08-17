package com.finalProject.teacherTools.Controllers;

import java.util.ArrayList;
import java.util.Collection;

import com.finalProject.teacherTools.Models.Assignment;
import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.AssignmentRepo;
import com.finalProject.teacherTools.Repos.ClassroomRepo;
import com.finalProject.teacherTools.Repos.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClassroomController {
    private StudentRepo studentRepo;
    private AssignmentRepo assignmentRepo;
    private ClassroomRepo classroomRepo;

    public ClassroomController(StudentRepo studentRepo, AssignmentRepo assignmentRepo, ClassroomRepo classroomRepo) {
        this.studentRepo = studentRepo;
        this.assignmentRepo = assignmentRepo;
        this.classroomRepo = classroomRepo;
    }

    @GetMapping("/classroom")
    public String displayClassroomPage(@RequestParam("id") Long id, Model model) {
        Classroom classroom = classroomRepo.findById(id).get();
        model.addAttribute("individualClassroom", classroom);
        Collection<Student> studentsInClass = (Collection<Student>) studentRepo.findAllByClassrooms(classroom);
        Iterable<Student> allStudents = studentRepo.findAll();
        Collection<Student> addableStudent = new ArrayList<Student>();
        for (Student student : allStudents) {
            if (!studentsInClass.contains(student)){
                addableStudent.add(student);
            }
        }
        model.addAttribute("allStudents", addableStudent);

        return "classroom-template";
    }

    @GetMapping("/classroom/roll-call")
    public String getAllStudentsForClassroom(@RequestParam("id") Long id, Model model) {
        Classroom classroom = classroomRepo.findById(id).get();
        model.addAttribute("individualClassroom", classroom);
        model.addAttribute("individualStudents", studentRepo.findAllByClassrooms(classroom));
        return "roll-call-template";
    }

    @PostMapping("/classroom/newAssignment")
    public String addNewAssignment(@RequestParam String name, String description, String assignedDate, String dueDate,
            String pointsValue, Long classroomId) {

        Classroom classroom = classroomRepo.findById(classroomId).get();
        Assignment assignmentToAdd = new Assignment(classroom, name, description, assignedDate, dueDate, pointsValue);
        assignmentRepo.save(assignmentToAdd);
        for (Student student : classroom.getStudents()) {
            assignmentToAdd.addStudent(student);
        }
        assignmentRepo.save(assignmentToAdd);

        return "redirect:/classroom?id=" + classroomId;
    }

    @PostMapping("/classroom/addStudent")
    public String addExistingStudent(@RequestParam("id") Long id, Long student, Model model) {
        Classroom classroom = classroomRepo.findById(id).get();
        model.addAttribute("individualStudents", studentRepo.findAllByClassrooms(classroom));
        Iterable<Assignment> allAssignments = classroom.getAssignments();
        Student studentToAdd = studentRepo.findById(student).get();
        classroom.addStudent(studentToAdd);
        classroomRepo.save(classroom);
        
        for(Assignment assignment: allAssignments){
            if(!assignment.getStudents().contains(studentToAdd))
            assignment.addStudent(studentToAdd);
            assignmentRepo.save(assignment);
        }
        

        return "redirect:/classroom" + "?id=" + classroom.getId();

    }

    @PostMapping("/classroom/deleteClassroom/{id}")
    public String deleteStudentClassroom (@PathVariable("id")Long id){
        Classroom studentClassroomToDelete = classroomRepo.findById(id).get();
        classroomRepo.deleteById(id);

        return "redirect:/";
    }

}
