package com.finalProject.teacherTools.Controllers;

import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Models.Grade;
import com.finalProject.teacherTools.Models.Note;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.*;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestfulApiControllers {

    @Resource
    private AssignmentRepo assignmentRepo;
    @Resource
    private ClassroomRepo classroomRepo;
    @Resource
    private GradeRepo gradeRepo;
    @Resource
    private NoteRepo noteRepo;
    @Resource
    private StudentRepo studentRepo;

    @PostMapping("/api")
    public String addNewClassroom(@RequestBody Classroom classroomToAdd){
        classroomRepo.save(classroomToAdd);
        return "redirect:/";
    }

    @PostMapping("/api/students")
    public String addnewStudent(@RequestBody Student studentToAdd){ 
        studentRepo.save(studentToAdd);
        return "redirect:/students";
    }

}
