package com.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.education.model.EducationLevel;

@Repository
public interface EducationLevelRepository extends JpaRepository<EducationLevel, Integer> {

}
