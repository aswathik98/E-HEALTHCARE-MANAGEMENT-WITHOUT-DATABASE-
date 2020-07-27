package dao;

import java.util.*;
import model.*;

public class DoctorOperations {
	Excelfile excel = new Excelfile();
	static List<Doctor> list1 = new ArrayList<Doctor>();
	static List<PatientRecord>list2 = new ArrayList<PatientRecord>();
	
	
	//Insert Doctor Details
	public List<Doctor> insert(Doctor doctor) throws Exception{
		list1.add(doctor);
		excel.excelgenerator(doctor,list1);
		list1.remove(doctor);
		return list1;
	}
	
	//Delete Doctor Details
	public List<Doctor> delete(Doctor doctor)throws Exception{
		list1.remove(doctor);
		return list1;
	}
	
	//patient Record
	public List<PatientRecord>  order(PatientRecord doctor) throws Exception{
		list2.add(doctor);
		excel.patientrecordgenerator(doctor,list2);
		list2.remove(doctor);
		return list2;
	}

//get doc details
	public void getAlldoctors() {
		excel.excelreader("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\Doctordetails.xlsx");
	}
	
	//get patient details
	public void getAllRecord() {
		excel.excelreader("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
	}
}
