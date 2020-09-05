package com.education.education.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//Education Year Tablosu İçin Değer Atamalar
@Entity
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@Table(name = "education_year")
public class EducationYear {

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AcademicYear academicYear;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private EducationLevel educationLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_period_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	// Constructors
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

	// Set ve get
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

	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;

	}

	public EducationPeriod getEducationPeriod() {
		return educationPeriod;
	}

	public void setEducationPeriod(EducationPeriod educationPeriod) {
		this.educationPeriod = educationPeriod;

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