package com.students.controller;

import com.students.model.StudentDto;
import com.students.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public StudentDto getStudents(@PathVariable Long id) {
        return studentService.getStudents(id);
    }

    @PostMapping
    public boolean addStudent(@RequestBody StudentDto student) {
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public boolean updateStudent(@PathVariable Long id, @RequestBody StudentDto student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
