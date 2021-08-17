package com.finalProject.teacherTools.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String name;
    @Lob
    private String description;
    private String assignedDate;
    private String dueDate;
    private String pointsValue;

    @ManyToOne
    @JsonIgnore
    private Classroom classroom;

    @ManyToMany
    private Collection<Student> students;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private Collection<Grade> grades;

    protected Assignment(){};

    public Assignment(Classroom classroom, String name, String description, String assignedDate, String dueDate, String pointsValue, Student... students){
        this.classroom = classroom;
        this.name = name;
        this.description = description;
        this.assignedDate = assignedDate;
        this.dueDate = dueDate;
        this.pointsValue = pointsValue;
        this.students = Set.of(students);
        this.grades  = new ArrayList<Grade>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPointsValue() {
        return pointsValue;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public Collection<Grade> getGrades() {
        return grades;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addGradesToAssignment(Grade grade){
        grades.add(grade);
    }

    public void deleteStudent(Student student){
        students.remove(student);
    }

    public double calculateAssignmentAverageGrade(){
        double studentGrades = 0;
        double totalGrades = grades.size();
        double averageGrade = 0;
        for(Grade grade: grades){
            studentGrades += grade.getGrade();
            averageGrade = Math.round((studentGrades / totalGrades));
        } return averageGrade;
    }



}
