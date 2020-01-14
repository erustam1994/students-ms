package com.students.mapper;

import com.students.model.StudentEntity;
import com.students.dto.StudentDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class StudentMapper {
    private StudentMapper() {
    }

    public static StudentDto StudentToStudentDto(StudentEntity studentEntity) {
        return StudentDto.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .universities(UniversityMapper.UniversitiesToUniversityDtos(studentEntity.getUniversities()))
                .birthday(studentEntity.getBirthday()).build();
    }

    public static StudentEntity StudentDtoToStudent(StudentDto studentDto) {
        return StudentEntity.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .universities(UniversityMapper.UniversityDtosToUniversities(studentDto.getUniversities()))
                .birthday(studentDto.getBirthday()).build();
    }

    public static List<StudentDto> StudentsToStudentDtos(Iterable<StudentEntity> students) {
        return StreamSupport.stream(students.spliterator(), false)
                .map(StudentMapper::StudentToStudentDto)
                .collect(Collectors.toList());
    }

    public static List<StudentEntity> StudentDtosToStudents(Iterable<StudentDto> studentDtos) {
        return StreamSupport.stream(studentDtos.spliterator(), false)
                .map(StudentMapper::StudentDtoToStudent)
                .collect(Collectors.toList());
    }

    public static Page<StudentDto> PageStudentsToPageStudentDtos(Page<StudentEntity> page){
        return page.map(StudentMapper::StudentToStudentDto);
    }

    public static Page<StudentEntity> PageStudentDtosToPageStudents(Page<StudentDto> page){
        return page.map(StudentMapper::StudentDtoToStudent);
    }

}
