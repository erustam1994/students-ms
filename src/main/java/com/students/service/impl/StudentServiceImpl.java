package com.students.service.impl;

import com.students.dao.Student;
import com.students.exception.StudentNotFoundException;
import com.students.dto.StudentDto;
import com.students.mapper.StudentMapper;
import com.students.repository.StudentRepository;
import com.students.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<StudentDto> getStudents(Pageable pageable) {
        return StudentMapper.PageStudentsToPageStudentDtos(studentRepository.findAll(pageable));
    }

    @Override
    public StudentDto getStudent(Long id) {
        return StudentMapper.StudentToStudentDto(studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("no-found")));
    }

    @Override
    public List<StudentDto> getStudentsByName(String name) {
        return StudentMapper.StudentsToStudentDtos(studentRepository.findStudentsByNameContains(name));
    }

    @Override
    public void addStudent(StudentDto student) {
        student.setId(null);
        studentRepository.save(StudentMapper.StudentDtoToStudent(student));
    }

    @Override
    public void updateStudent(Long id, StudentDto student) {
        Student newStudent = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("no-found"));
        newStudent.setName(student.getName());
        newStudent.setBirthday(student.getBirthday());
        studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("not-found")));
    }
}
