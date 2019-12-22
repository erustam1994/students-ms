package com.students.service;

import com.students.model.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    StudentDto getStudents(Long id);
    boolean addStudent(StudentDto student);
    boolean deleteStudent(Long id);
    boolean updateStudent(Long id, StudentDto student);
}
