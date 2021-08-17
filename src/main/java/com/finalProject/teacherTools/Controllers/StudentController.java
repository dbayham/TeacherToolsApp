package com.finalProject.teacherTools.Controllers;

import java.util.Collection;

import com.finalProject.teacherTools.Models.Assignment;
import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Models.Grade;
import com.finalProject.teacherTools.Models.Note;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.AssignmentRepo;
import com.finalProject.teacherTools.Repos.ClassroomRepo;
import com.finalProject.teacherTools.Repos.GradeRepo;
import com.finalProject.teacherTools.Repos.NoteRepo;
import com.finalProject.teacherTools.Repos.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    private StudentRepo studentRepo;
    private AssignmentRepo assignmentRepo;
    private NoteRepo noteRepo;
    private GradeRepo gradeRepo;
    private ClassroomRepo classroomRepo;

    public StudentController(StudentRepo studentRepo, AssignmentRepo assignmentRepo, NoteRepo noteRepo, GradeRepo gradeRepo, ClassroomRepo classroomRepo) {
        this.studentRepo = studentRepo;
        this.assignmentRepo = assignmentRepo;
        this.noteRepo = noteRepo;
        this.gradeRepo = gradeRepo;
        this.classroomRepo = classroomRepo;
   
    }
   

    @GetMapping("/students")
    public String displayAllStudents(Model model){
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "students-template";
    }

    @GetMapping("/student")
    public String displayStudentPage(@RequestParam("id") Long id, Model model) {
        Student student = studentRepo.findById(id).get();
        model.addAttribute("individualStudent", student);
        return "single-student-template";
    }


    @PostMapping("/student/{id}")
    public String addStudentNote(@PathVariable("id") Long id, Model model,String title, String note, String date){
        Student studentToAddNote = studentRepo.findById(id).get();
        Note noteToDisplay = new Note(title, note, date);
        studentToAddNote.addNoteToStudent(noteToDisplay);
        studentRepo.save(studentToAddNote);
        
        
        model.addAttribute("note", noteToDisplay);
        model.addAttribute("individualStudent", studentToAddNote);

        return "single-student-template";
        }

    @PostMapping("/student/deletenote/{id}")
    public String deleteStudentNote(@PathVariable("id") Long id, Long noteId) {
        Student studentToChange = studentRepo.findById(id).get();
        Note noteToDelete = noteRepo.findById(noteId).get();
        studentToChange.removeNote(noteToDelete);
        noteRepo.deleteById(noteId);
        studentRepo.save(studentToChange);

        return "redirect:/student" + "?id=" +studentToChange.getId();
    }

    @PostMapping("/student/deletegrade/{id}")
    public String deleteStudentGrade(@PathVariable("id") Long id, Long gradeId){
        Student studentGradeToDelete = studentRepo.findById(id).get();
        Grade gradeToDelete = gradeRepo.findById(gradeId).get();
        studentGradeToDelete.removeGrade(gradeToDelete);
        gradeRepo.deleteById(gradeId);
        studentRepo.save(studentGradeToDelete);

        return "redirect:/student" + "?id=" + studentGradeToDelete.getId();
    }

    @PostMapping("/students/add")
    public String addNewStudent(String name, String studentImage, String guardianName, String guardianEmail, String guardianPhone, int birthdayDay, int birthdayMonth, int birthdayYear){
        Student studentToAdd = new Student(name, studentImage, guardianName, guardianEmail, guardianPhone, birthdayDay, birthdayMonth, birthdayYear);
        studentRepo.save(studentToAdd);
        return "redirect:/students";
    }

    @PostMapping("/classroom/deletestudent/{id}")
    public String deleteStudentFromClassroom (@PathVariable("id")Long id){
        Student studentToDelete = studentRepo.findById(id).get();
        Collection<Classroom> studentClassrooms = studentToDelete.getClassrooms();
        Collection<Assignment> studentAssignments = studentToDelete.getAssignments();
        for(Classroom classroom : studentClassrooms) {
            classroom.deleteStudent(studentToDelete);
        }
        for(Assignment assignment : studentAssignments) {
            assignment.deleteStudent(studentToDelete);
        }
    
        studentRepo.deleteById(id);

        return "redirect:/students";
    }

}
