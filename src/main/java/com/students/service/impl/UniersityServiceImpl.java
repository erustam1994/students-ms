package com.students.service.impl;

import com.students.dto.UniversityDto;
import com.students.exception.NotFoundException;
import com.students.mapper.UniversityMapper;
import com.students.repository.UniversityRepository;
import com.students.service.UniversityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UniersityServiceImpl implements UniversityService {

    private UniversityRepository universityRepository;

    public UniersityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public Page<UniversityDto> getStudents(Pageable pageable) {
        return UniversityMapper.PageUniversitiesToUniversityDtos(universityRepository.findAll(pageable));
    }

    @Override
    public UniversityDto getStudent(Long id) {
        return UniversityMapper.UniversityToUniversityDto(universityRepository.findById(id).orElseThrow(()->new NotFoundException("not-found")));
    }

    @Override
    public void addUniversity(UniversityDto universityDto) {
        universityDto.setId(null);
        universityRepository.save(UniversityMapper.UniversityDtoToUniversity(universityDto));
    }
}
