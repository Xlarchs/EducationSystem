package com.education.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.education.model.EducationYear;
import com.education.education.repository.EducationYearRepository;

@RestController
@RequestMapping("/api")
public class EducationYearController {
	@Autowired
	private EducationYearRepository educationYearRepository;

	@GetMapping("/educationPeriods")
	public List<EducationYear> getAllEducationYears() {
		return this.educationYearRepository.findAll();
	}

	@PostMapping("/newEducationYear")
	public EducationYear createEducationYear(@RequestBody EducationYear createEducationYear) {
		return educationYearRepository.save(createEducationYear);
	}
	// get education year
	// get education year by id
	// save education year
	// update education year
	// delete education year

}
