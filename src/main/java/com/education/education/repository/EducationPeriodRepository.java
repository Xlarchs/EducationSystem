package com.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.education.model.EducationPeriod;

@Repository
public interface EducationPeriodRepository extends JpaRepository<EducationPeriod, Integer> {

}
