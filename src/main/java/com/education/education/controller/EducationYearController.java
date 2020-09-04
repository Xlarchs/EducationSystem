package com.education.education.controller;

import java.util.HashMap;
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

import com.education.education.exception.ResourceNotFoundException;
import com.education.education.model.EducationYear;
import com.education.education.repository.EducationYearRepository;

@RestController
@RequestMapping("/api")
public class EducationYearController {
	@Autowired
	private EducationYearRepository educationYearRepository;

	// Education Years Tablosundaki Verileri Çekiyoruz
	@GetMapping("/educationYears")
	public List<EducationYear> getAllEducationYears() {
		return this.educationYearRepository.findAll();
	}

	// Education Years Tablosuna POST İle Yeni Bir Veri Ekliyoruz
	@PostMapping("/newEducationYear")
	public EducationYear createEducationYear(@RequestBody EducationYear createEducationYear) {
		return educationYearRepository.save(createEducationYear);

	}

	// Education Years Tablosunda Verilen Id'ye Göre Veri Güncelleme
	@PutMapping("/educationYears/{id}")
	public ResponseEntity<EducationYear> updateEducationYear(@PathVariable(value = "id") Integer id,
			@Validated @RequestBody EducationYear educationYearDetatils) throws ResourceNotFoundException {

		// Verilen Id'ye Göre Veriyi Oluşturduğumuz educationYear Değerine Atıyor Eğer,
		// Verilen Id Veri Tablosunda Yok İse "Education Year Bulunamadı" hatası veriyor
		EducationYear educationYear = educationYearRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Education Year bulunamadı : : " + id));

		// Verilen Id Tabloda Var İse Verileri Güncelliyoruz.
		educationYear.setEducationLevel(educationYearDetatils.getEducationLevel());
		educationYear.setEducationPeriod(educationYearDetatils.getEducationPeriod());
		educationYear.setEnd_date(educationYearDetatils.getEnd_date());
		educationYear.setStart_date(educationYearDetatils.getStart_date());
		educationYear.setTotal_course_week(educationYear.getTotal_course_week());
		educationYear.setAcademicYear(educationYearDetatils.getAcademicYear());
		return ResponseEntity.ok(this.educationYearRepository.save(educationYear));
	}

	// Verilen id'ye göre education year silme işlemi
	@DeleteMapping("/educationYear/{id}")
	public Map<String, Boolean> deleteEducationYear(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		// Verilen id veri tablosunda yok ise "Education Year Bulunamadı" hatası veriyor
		EducationYear educationYear = educationYearRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id'si " + id + " Olan Education Year bulunamadı :"));
		educationYearRepository.delete(educationYear);
		Map<String, Boolean> response = new HashMap<>();
		response.put("silindi", Boolean.TRUE);
		return response;

	}

}
