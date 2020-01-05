package com.students.service;

import com.students.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<StudentDto> getStudents(Pageable pageable);

    StudentDto getStudent(Long id);

    List<StudentDto> getStudentsByName(String name);

    void addStudent(StudentDto student);

    void updateStudent(Long id, StudentDto student);

    void deleteStudent(Long id);
}
