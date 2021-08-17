package com.finalProject.teacherTools.Repos;

import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
    Iterable<Student> findAllByClassrooms(Classroom classroom);
}
