package dao;
import model.*;
import model.Patient;
import java.util.*;

public class CRUDOperations {
	static List<Patient> listc = new ArrayList<Patient>();
	static int value = 0;
	Excelfile excel = new Excelfile();
	public List<Patient>addListPatient(Patient patient) throws Exception{
		listc.add(patient);
		excel.patientexcelinsert(patient,listc);
		listc.remove(patient);
		return listc;
		
	}
	
	public void getAllPatients(){
		excel.excelreader("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
	}
	

}
