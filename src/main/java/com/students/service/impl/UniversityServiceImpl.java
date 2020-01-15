package com.students.service.impl;

import com.students.dto.UniversityDto;
import com.students.exception.NotFoundException;
import com.students.mapper.UniversityMapper;
import com.students.model.StudentEntity;
import com.students.model.UniversityEntity;
import com.students.repository.UniversityRepository;
import com.students.service.UniversityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    private UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public Page<UniversityDto> getStudents(Pageable pageable) {
        return UniversityMapper.PageUniversitiesToUniversityDtos(universityRepository.findAll(pageable));
    }

    @Override
    public UniversityDto getStudent(Long id) {
        return UniversityMapper.UniversityToUniversityDto(universityRepository.findById(id).orElseThrow(()->new NotFoundException("university.not-found")));
    }

    @Override
    public void addUniversity(UniversityDto universityDto) {
        universityDto.setId(null);
        universityRepository.save(UniversityMapper.UniversityDtoToUniversity(universityDto));
    }

    @Override
    public void updateUniversity(Long id, UniversityDto student) {
        UniversityEntity newUniversityEntity = universityRepository.findById(id).orElseThrow(()->new NotFoundException("university.not-found"));
        newUniversityEntity.setName(student.getName());
        universityRepository.save(newUniversityEntity);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.delete(universityRepository.findById(id)
                .orElseThrow(()->new NotFoundException("university.not-found")));
    }

}
