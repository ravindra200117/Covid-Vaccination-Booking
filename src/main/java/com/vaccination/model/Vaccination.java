package com.vaccination.model;

public class Vaccination 
{
	private int cvcno;
	private String supervisor;
	private String vaccinecenter;
	private String vaccinename;
	private String dose;
	private String namePerson;
	private long mobile;
	private String workinghour;
	
	public Vaccination(int cvcno, String supervisor, String vaccinecenter, String vaccinename, String dose,
			String namePerson, long mobile, String workinghour) {
		super();
		this.cvcno = cvcno;
		this.supervisor = supervisor;
		this.vaccinecenter = vaccinecenter;
		this.vaccinename = vaccinename;
		this.dose = dose;
		this.namePerson = namePerson;
		this.mobile = mobile;
		this.workinghour = workinghour;
	}
	
	
	public Vaccination(String vaccinecenter, String workinghour) {
		super();
		this.vaccinecenter = vaccinecenter;
		this.workinghour = workinghour;
	}


	public int getCvcno() {
		return cvcno;
	}
	public void setCvcno(int cvcno) {
		this.cvcno = cvcno;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getVaccinecenter() {
		return vaccinecenter;
	}
	public void setVaccinecenter(String vaccinecenter) {
		this.vaccinecenter = vaccinecenter;
	}
	public String getVaccinename() {
		return vaccinename;
	}
	public void setVaccinename(String vaccinename) {
		this.vaccinename = vaccinename;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getNamePerson() {
		return namePerson;
	}
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getWorkinghour() {
		return workinghour;
	}
	public void setWorkinghour(String workinghour) {
		this.workinghour = workinghour;
	}
	
	
	
	
}
