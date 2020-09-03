package com.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.education.model.AcademicYear;

@Repository
public interface AcademyYearRepository extends JpaRepository<AcademicYear, Integer> {

}
