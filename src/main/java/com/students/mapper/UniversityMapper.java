package com.students.mapper;

import com.students.dto.UniversityDto;
import com.students.model.UniversityEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class UniversityMapper {
    private UniversityMapper() {
    }

    public static UniversityDto UniversityToUniversityDto(UniversityEntity universityEntity) {
        return UniversityDto.builder()
                .id(universityEntity.getId())
                .name(universityEntity.getName())
                .build();
    }

    public static UniversityEntity UniversityDtoToUniversity(UniversityDto universityDto) {
        return UniversityEntity.builder()
                .id(universityDto.getId())
                .name(universityDto.getName())
                .build();
    }

    public static Set<UniversityDto> UniversitiesToUniversityDtos(Iterable<UniversityEntity> universityEntities) {
        return StreamSupport.stream(universityEntities.spliterator(), false)
                .map(UniversityMapper::UniversityToUniversityDto)
                .collect(Collectors.toSet());
    }

    public static Set<UniversityEntity> UniversityDtosToUniversities(Iterable<UniversityDto> universityDtos) {
        return StreamSupport.stream(universityDtos.spliterator(), false)
                .map(UniversityMapper::UniversityDtoToUniversity)
                .collect(Collectors.toSet());
    }

    public static Page<UniversityDto> PageUniversitiesToUniversityDtos(Page<UniversityEntity> page) {
        return page.map(UniversityMapper::UniversityToUniversityDto);
    }

    public static Page<UniversityEntity> PageUniversityDtosToUniversities(Page<UniversityDto> page) {
        return page.map(UniversityMapper::UniversityDtoToUniversity);
    }

}
