package com.education.education.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "education_year")
public class EducationYear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", referencedColumnName = "id")
	private AcademicYear academicYear;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id", referencedColumnName = "id")
	private EducationLevel educationLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_period_id", referencedColumnName = "id")
	private EducationPeriod educationPeriod;

	@Column(name = "start_date")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date start_date;

	@Column(name = "end_date")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date end_date;

	@Column(name = "total_course_week")
	private int total_course_week;

	public EducationYear(int id, AcademicYear academicYear, EducationLevel educationLevel,
			EducationPeriod educationPeriod, Date start_date, Date end_date, int total_course_week) {
		super();
		this.id = id;
		this.academicYear = academicYear;
		this.educationLevel = educationLevel;
		this.educationPeriod = educationPeriod;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_course_week = total_course_week;
	}

	public EducationYear() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
		academicYear.getEducationYears().add(this);
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
		educationLevel.getEducationYears().add(this);
	}

	public EducationPeriod getEducationPeriod() {
		return educationPeriod;
	}

	public void setEducationPeriod(EducationPeriod educationPeriod) {
		this.educationPeriod = educationPeriod;
		educationPeriod.getEducationYears().add(this);
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getTotal_course_week() {
		return total_course_week;
	}

	public void setTotal_course_week(int total_course_week) {
		this.total_course_week = total_course_week;
	}

}