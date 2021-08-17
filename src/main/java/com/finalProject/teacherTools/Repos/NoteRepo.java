package com.finalProject.teacherTools.Repos;

import com.finalProject.teacherTools.Models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<Note, Long> {
}
