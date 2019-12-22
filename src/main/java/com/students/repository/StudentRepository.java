package com.students.repository;

import com.students.model.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.students.db.StudentMock.STUDENTS;
import static com.students.db.StudentMock.nextId;

@Repository
public class StudentRepository {

    public List<StudentDto> getStudents() {
        return STUDENTS;
    }

    public StudentDto getStudents(Long id) {
        return STUDENTS.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void addStudent(StudentDto student) {
        student.setId(++nextId);
        STUDENTS.add(student);
    }

    public void update(StudentDto student) {
        STUDENTS.remove(getStudents(student.getId()));
        STUDENTS.add(student);
    }

    public void deleteStudent(StudentDto student) {
        STUDENTS.remove(student);
    }
}
