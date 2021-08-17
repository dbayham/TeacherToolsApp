package com.finalProject.teacherTools.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private Long id;

    private double grade;
    private double maximumGrade;

    @ManyToOne
    private Assignment assignment;

    @ManyToMany
    private Collection<Student> students;

    protected Grade(){};

    public Grade(Assignment assignment, double grade, double maximumGrade){
        this.assignment = assignment;
        this.grade = grade;
        this.maximumGrade = maximumGrade;
        this.students = new ArrayList<Student>();
    }

    public Long getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public double getMaximumGrade() {
        return maximumGrade;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void addStudentToGrade(Student student){
        students.add(student);
    }
}
