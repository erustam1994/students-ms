package com.students.service;

import com.students.dto.UniversityDto;
import com.students.model.UniversityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface UniversityService {
    Page<UniversityDto> getStudents(Pageable pageable);

    UniversityDto getStudent(Long id);

    void addUniversity(UniversityDto student);

    void updateUniversity(Long id, UniversityDto student);

    void deleteUniversity(Long id);
}
