package model;
import java.io.*;

import dao.*;

public class PatientRecord  {
	private String diagnosis = "";
	private String prescription = "";
	private String time;
	private String id;
	
	public PatientRecord(String diagnosis, String prescription, String time, String id) {
		super();
		this.diagnosis = diagnosis;
		this.prescription = prescription;
		this.time = time;
		this.id = id;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
