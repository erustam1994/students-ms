package com.students.service.impl;

import com.students.model.StudentEntity;
import com.students.exception.NotFoundException;
import com.students.dto.StudentDto;
import com.students.mapper.StudentMapper;
import com.students.repository.StudentRepository;
import com.students.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
                .orElseThrow(()->new NotFoundException("not-found")));
    }

    @Override
    public void addStudent(StudentDto student) {
        student.setId(null);
        studentRepository.save(StudentMapper.StudentDtoToStudent(student));
    }

    @Override
    public void updateStudent(Long id, StudentDto student) {
        StudentEntity newStudentEntity = studentRepository.findById(id).orElseThrow(()->new NotFoundException("not-found"));
        newStudentEntity.setName(student.getName());
        newStudentEntity.setBirthday(student.getBirthday());
        studentRepository.save(newStudentEntity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(studentRepository.findById(id)
                .orElseThrow(()->new NotFoundException("not-found")));
    }
}
