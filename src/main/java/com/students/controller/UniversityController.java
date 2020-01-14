package com.students.controller;

import com.students.dto.UniversityDto;
import com.students.service.UniversityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("universities")
public class UniversityController {

    private UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public Page<UniversityDto> getUniversities(Pageable pageable){
        return universityService.getStudents(pageable);
    }

    @GetMapping("{id}")
    public UniversityDto getUniversity(@PathVariable Long id){
        return universityService.getStudent(id);
    }

    @PostMapping
    public void addUniversity(@RequestBody UniversityDto universityDto){
        universityService.addUniversity(universityDto);
    }

}
