package com.students.mapper;

import com.students.dao.Student;
import com.students.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class StudentMapper {
    private StudentMapper() {
    }

    public static StudentDto StudentToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .birthday(student.getBirthday()).build();
    }

    public static Student StudentDtoToStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .birthday(studentDto.getBirthday()).build();
    }

    public static List<StudentDto> StudentsToStudentDtos(Iterable<Student> students) {
        return StreamSupport.stream(students.spliterator(), false)
                .map(StudentMapper::StudentToStudentDto)
                .collect(Collectors.toList());
    }

    public static List<Student> StudentDtosToStudents(Iterable<StudentDto> studentDtos) {
        return StreamSupport.stream(studentDtos.spliterator(), false)
                .map(StudentMapper::StudentDtoToStudent)
                .collect(Collectors.toList());
    }
}
