package com.education.education.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.education.business.IEducationYearService;
import com.education.education.exception.ResourceNotFoundException;
import com.education.education.model.EducationYear;

@RestController
@RequestMapping("/api")
public class EducationYearController {
	@Autowired
	private IEducationYearService educationYearService;

	public EducationYearController(IEducationYearService educationYearService) {
		super();
		this.educationYearService = educationYearService;
	}

	// Education Years Tablosundaki Verileri Çekiyoruz

	@GetMapping("/educationYears")
	public List<EducationYear> getAllEducationYears() {

		return educationYearService.getAllEducationYears();
	}

	// Education Years Tablosuna POST İle Yeni Bir Veri Ekliyoruz
	@PostMapping("/newEducationYear")
	public EducationYear createEducationYear(@RequestBody EducationYear educationYear) {

		return educationYearService.createEducationYear(educationYear);

	}

	// Education Years Tablosunda Verilen Id'ye Göre Veri Güncelleme
	@PutMapping("/educationYears/{id}")
	public ResponseEntity<EducationYear> updateEducationYear(@PathVariable(value = "id") Integer id,
			@Validated @RequestBody EducationYear educationYearDetails) throws ResourceNotFoundException {

		return educationYearService.updateEducationYear(id, educationYearDetails);
	}

	// Verilen id'ye göre education year silme işlemi
	@DeleteMapping("/educationYear/{id}")
	public Map<String, Boolean> deleteEducationYear(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		return educationYearService.deleteEducationYear(id);
	}

}
