package com.students.repository;

import com.students.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByNameContains(String name);
}
