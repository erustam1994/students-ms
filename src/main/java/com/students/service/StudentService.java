package com.students.service;

import com.students.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudent(Long id);

    void addStudent(StudentDto student);

    void updateStudent(Long id, StudentDto student);

    void deleteStudent(Long id);
}
