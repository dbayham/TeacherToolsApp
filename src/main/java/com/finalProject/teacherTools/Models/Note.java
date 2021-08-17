package com.finalProject.teacherTools.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String title;
    @Lob
    private String note;
    private String noteDate;

    @ManyToOne
    @JsonIgnore
    private Student student;

    protected Note(){};

    public Note(String title, String note, String noteDate){
        this.title = title;
        this.note = note;
        this.noteDate = noteDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public Student getStudents() {
        return student;
    }
}
