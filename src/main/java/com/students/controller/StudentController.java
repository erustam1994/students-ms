package com.students.controller;

import com.students.dto.StudentDto;
import com.students.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Page<StudentDto> getStudent(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @GetMapping("{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDto student) {
        studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
