package com.education.education.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "academic_year")
public class AcademicYear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "academicYear", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<EducationYear> educationYears;

	public AcademicYear() {
		educationYears = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EducationYear> getEducationYears() {
		return educationYears;
	}

	public void setEducationYears(Set<EducationYear> educationYears) {
		this.educationYears = educationYears;
		for (EducationYear educationYear : educationYears) {
			educationYear.setAcademicYear(this);
		}
	}
}
