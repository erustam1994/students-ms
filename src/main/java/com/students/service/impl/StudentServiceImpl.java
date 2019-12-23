package com.students.service.impl;

import com.students.dto.StudentDto;
import com.students.exception.ResourceNotFoundException;
import com.students.mapper.StudentMapper;
import com.students.repository.StudentRepository;
import com.students.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getStudents() {
        return StudentMapper.StudentsToStudentDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto getStudent(Long id) {
        return StudentMapper.StudentToStudentDto(studentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public void addStudent(StudentDto student) {
        student.setId(null);
        studentRepository.save(StudentMapper.StudentDtoToStudent(student));
    }

    @Override
    public void updateStudent(Long id, StudentDto student) {
        student.setId(getStudent(id).getId());
        studentRepository.save(StudentMapper.StudentDtoToStudent(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(studentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }
}
