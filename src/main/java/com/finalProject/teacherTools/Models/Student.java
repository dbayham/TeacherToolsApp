package com.finalProject.teacherTools.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String studentImage;
    private String guardianName;
    private String guardianEmail;
    private String guardianPhone;
    private int birthdayDay;
    private int birthdayMonth;
    private int birthdayYear;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Collection<Classroom> classrooms;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Collection<Assignment> assignments;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Grade> grades;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Note> notes;

    protected Student(){};

    public Student(String name, String studentImage, String guardianName, String guardianEmail, String guardianPhone, int birthdayDay,
                   int birthdayMonth, int birthdayYear, Classroom... classrooms){
        this.name = name;
        this.studentImage = studentImage;
        this.guardianName = guardianName;
        this.guardianEmail = guardianEmail;
        this.guardianPhone = guardianPhone;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.classrooms = Set.of(classrooms);
        this.grades = new ArrayList<Grade>();
        this.assignments = new ArrayList<Assignment>();
        this.notes = new ArrayList<Note>();

    };

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public int getBirthdayDay() {
        return birthdayDay;
    }

    public int getBirthdayMonth() {
        return birthdayMonth;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public Collection<Classroom> getClassrooms() {
        return classrooms;
    }

    public Collection<Assignment> getAssignments() {
        return assignments;
    }

    public Collection<Grade> getGrades() {
        return grades;
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    public void addNoteToStudent(Note note){
        notes.add(note);
    }

    public void removeNote(Note note) {
       notes.remove(note);
    }

    public void removeGrade(Grade grade){
        grades.remove(grade);
    }

    public void deleteAssignment(Assignment assignment){
        assignments.remove(assignment);
    }

   public double calculateTotalGrade(){
        double studentGrade = 0;
        double maximumStudentGrade = 0;
        double studentTotalGrade = 0;
        for(Grade grade: grades){
            studentGrade += grade.getGrade();
            maximumStudentGrade += grade.getMaximumGrade();
            studentTotalGrade = Math.round((studentGrade / maximumStudentGrade)*100);
        } return studentTotalGrade;
    }
}
