package com.education.education.business;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.education.education.exception.ResourceNotFoundException;
import com.education.education.model.EducationYear;

@Repository
public interface IEducationYearService {
	public List<EducationYear> getAllEducationYears();

	public EducationYear createEducationYear(EducationYear educationYear);

	public ResponseEntity<EducationYear> updateEducationYear(Integer id, EducationYear educationYearDetails)
			throws ResourceNotFoundException;

	public Map<String, Boolean> deleteEducationYear(Integer id) throws ResourceNotFoundException;

}
