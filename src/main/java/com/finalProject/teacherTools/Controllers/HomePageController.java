package com.finalProject.teacherTools.Controllers;

import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Repos.ClassroomRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
    private ClassroomRepo classroomRepo;

    public HomePageController(ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("classrooms", classroomRepo.findAll());
        return "home-page-template";
    }

    @GetMapping("about-page-template")
    public String displayAboutPage(Model model) {
        return "about-page-template";
    }

    @PostMapping("/add-classroom")
    public String addNewClassroom(String subject, int gradeLevel, String room, String time, int year, String semester){
        Classroom classroomToAdd = new Classroom (subject, gradeLevel, room, time, year, semester);
        classroomRepo.save(classroomToAdd);
        return "redirect:/";
    }
    
}
