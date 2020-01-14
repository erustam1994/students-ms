package com.students.repository;

import com.students.model.StudentEntity;
import com.students.model.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {



}
