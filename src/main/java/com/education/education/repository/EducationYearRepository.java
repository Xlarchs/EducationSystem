package com.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.education.model.EducationYear;

@Repository
public interface EducationYearRepository extends JpaRepository<EducationYear, Integer> {

}
