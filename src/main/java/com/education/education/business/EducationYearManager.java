package com.education.education.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.education.education.exception.ResourceNotFoundException;
import com.education.education.model.EducationYear;
import com.education.education.repository.EducationYearRepository;

@Repository
public class EducationYearManager implements IEducationYearService {

	@Autowired
	private EducationYearRepository educationYearRepository;

	@Override
	public List<EducationYear> getAllEducationYears() {

		return this.educationYearRepository.findAll();
	}

	@Override
	public EducationYear createEducationYear(EducationYear educationYear) {
		return educationYearRepository.save(educationYear);

	}

	@Override
	public ResponseEntity<EducationYear> updateEducationYear(Integer id, EducationYear educationYearDetails)
			throws ResourceNotFoundException {

		// Verilen Id'ye Göre Veriyi Oluşturduğumuz educationYear Değerine Atıyor Eğer,
		// Verilen Id Veri Tablosunda Yok İse "Education Year Bulunamadı" hatası veriyor
		EducationYear educationYear = educationYearRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Education Year bulunamadı : : " + id));

		// Verilen Id Tabloda Var İse Verileri Güncelliyoruz.
		educationYear.setEducationLevel(educationYearDetails.getEducationLevel());
		educationYear.setEducationPeriod(educationYearDetails.getEducationPeriod());
		educationYear.setEnd_date(educationYearDetails.getEnd_date());
		educationYear.setStart_date(educationYearDetails.getStart_date());
		educationYear.setTotal_course_week(educationYear.getTotal_course_week());
		educationYear.setAcademicYear(educationYearDetails.getAcademicYear());
		return ResponseEntity.ok(this.educationYearRepository.save(educationYear));
	}

	@Override
	public Map<String, Boolean> deleteEducationYear(Integer id) throws ResourceNotFoundException {
		// Verilen id veri tablosunda yok ise "Education Year Bulunamadı" hatası veriyor
		EducationYear educationYear = educationYearRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id'si " + id + " Olan Education Year bulunamadı :"));
		educationYearRepository.delete(educationYear);
		Map<String, Boolean> response = new HashMap<>();
		response.put("silindi", Boolean.TRUE);
		return response;

	}

}
