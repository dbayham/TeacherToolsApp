package com.finalProject.teacherTools.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Classroom {
    @Id
    @GeneratedValue
    private Long id;

    private String subject;
    private int gradeLevel;
    private String room;
    private String time;
    private int year;
    private String semester;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Assignment> assignments;

    @ManyToMany
    @JsonIgnore
    private Collection<Student> students;

    public Classroom(String subject, int gradeLevel, String room, String time, int year, String semester, Student... students){
        this.subject = subject;
        this.gradeLevel = gradeLevel;
        this.room = room;
        this.time = time;
        this.year = year;
        this.semester = semester;
        this.students = Set.of(students);
    }

    protected Classroom() {
    }

    public String getSubject(){
        return subject;
    }

    public Long getId() {
        return id;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public Collection<Assignment> getAssignments() {
        return assignments;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){students.add(student);}


    public void deleteStudent(Student student){
        students.remove(student);
    }
}
