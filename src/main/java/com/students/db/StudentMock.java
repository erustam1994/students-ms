package com.students.db;

import com.students.model.StudentDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentMock {

    public static final List<StudentDto> STUDENTS = new ArrayList<>();
    public static Long nextId= 0L;

    static
    {
        STUDENTS.add(StudentDto.builder().id(++nextId).name("Ayaz").birthday(LocalDate.of(1994,3,2)).build());
        STUDENTS.add(StudentDto.builder().id(++nextId).name("Emin").birthday(LocalDate.of(1992,1,23)).build());
        STUDENTS.add(StudentDto.builder().id(++nextId).name("Aygun").birthday(LocalDate.of(1990,12,4)).build());
        STUDENTS.add(StudentDto.builder().id(++nextId).name("Gunel").birthday(LocalDate.of(1989,5,7)).build());
    }


}
