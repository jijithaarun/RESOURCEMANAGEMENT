package com.resource.app.model;

import java.sql.Blob;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;

	private LocalDate registrationDate=LocalDate.now();

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String district;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private Integer pincode;

	@Column(nullable = false)
	private String nationality;
	
	@Column(nullable=false)
	private String gender;
	
	@Column(nullable=false)
	private String phone;
	
	private LocalDate datoOfBirth;
	
	private String email;

	@ManyToOne
	@JoinColumn(name = "paymentId")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@Column(length=1000)
	private byte[] photo;
	private String pictureName; 

	private String status;

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDatoOfBirth() {
		return datoOfBirth;
	}

	public void setDatoOfBirth(LocalDate datoOfBirth) {
		this.datoOfBirth = datoOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
