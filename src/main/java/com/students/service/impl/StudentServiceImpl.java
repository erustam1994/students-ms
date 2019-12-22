package com.students.service.impl;

import com.students.exception.StudentException;
import com.students.model.StudentDto;
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
        return studentRepository.getStudents();
    }

    @Override
    public StudentDto getStudents(Long id) {
        return studentRepository.getStudents(id);
    }

    @Override
    public boolean addStudent(StudentDto student) {
        if (studentRepository.getStudents(student.getId()) == null) {
            studentRepository.addStudent(student);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteStudent(Long id) {
        StudentDto student = getStudents(id);
        if (student == null) return false;
        else {
            studentRepository.deleteStudent(student);
            return true;
        }
    }

    @Override
    public boolean updateStudent(Long id, StudentDto student) {
        StudentDto currentStudent = studentRepository.getStudents(id);
        if (currentStudent == null) throw new StudentException("Student not found");

        student.setId(id);
        student.setName((student.getName() == null) ? currentStudent.getName() : student.getName().trim());
        student.setBirthday((student.getBirthday() == null) ? currentStudent.getBirthday() : student.getBirthday());

        studentRepository.update(student);

        return true;
    }
}
