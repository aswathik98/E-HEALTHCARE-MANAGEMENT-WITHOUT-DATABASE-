package controller;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import businesslogic.*;
import model.Doctor;
import model.Patient;
import model.PatientRecord;
import dao.*;



class first{
	static Map<Integer,Patient> map= new HashMap<Integer,Patient>();
	int choice;
	CRUDOperations crud = new CRUDOperations();
	
//admin
void admin() {
		Scanner sc = new Scanner(System.in);
		
		do {
			String pname,number;
			String pid;
			String name;
			String id;
			String  age;
			String sex;
			String blood;
			Doctor doctor=null;
			Patient patient= null;
			List<Doctor> list1=new ArrayList<Doctor>();
			
			DoctorOperations doc = new DoctorOperations();
			CRUDOperations crud = new CRUDOperations();
			Excelfile excel = new Excelfile();
			System.out.println("1. Insert Doctor Details: ");
			System.out.println("2. Insert Patient Details ");
			System.out.println("3. Delete Doctor details:");
			System.out.println("4. Get Doctor Details");
			System.out.println("5. Patient Details");
			System.out.println("6. Delete Patient Details: ");
			System.out.println("7.Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("-----INSERT DOCTOR DETAILS-------");
				System.out.println("Enter doctor's name:");
				name = sc.next();
				System.out.println("Enter doctor's  id");
				id =sc.next();
				
				doctor = new Doctor(name,id);
				try {
					doc.insert(doctor);
				}catch(Exception e) {
					e.getMessage();
				}
				System.out.println("Inserted Successfully!");
				break;
			case 2:
				System.out.println("------------INSERT PATIENT DETAILS------------------");
				System.out.println("Enter name:");
				name=sc.next();
				System.out.println("Enter id :");
				id = sc.next();
				System.out.println("Enter gender:");
				sex = sc.next();
				System.out.println("Enter age:");
				age = sc.next();
				System.out.println("Enter Blood Group:");
				blood = sc.next();
				patient = new Patient(name,id,sex,age,blood);
				try {
					crud.addListPatient(patient);
				}catch(Exception e) {
					e.getMessage();
				}
				System.out.println("Inserted Successfully!");
				
				break;
			case 3 :
				System.out.println("-----DELETE DOCTOR DETAILS--------------");
				System.out.println("Enter doctor id to be deleted:");
				id=sc.next();
				excel.deleteitem(id);
				System.out.println("*----------------------------------------*");
				break;
			case 4:
				System.out.println("----GET DOCTOR DETAILS-------------");
				System.out.println("*----------------------------------------*");
				System.out.println("Doctor_Name         ID    ");
				System.out.println("*----------------------------------------*");
				doc.getAlldoctors();
				System.out.println("*----------------------------------------*");
				break;
			case 5:
				System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
				System.out.println("                    Patient Details               ");
				System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
				System.out.println(" Name           ID              AGE            SEX           BLOOD_GROUP ");
				System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
				crud.getAllPatients();
				System.out.println("*--------------------------------------------------------------------------------------------------------------------------------*");		
				break;
			case 6:
				System.out.println("-----DELETE PATIENT DETAILS--------------");
				System.out.println("Enter patient id to be deleted:");
				id=sc.next();
				excel.deletepatientitem(id);
				System.out.println("*----------------------------------------*");
				break;
			case 7:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("--------------INVALID CHOICE-------------------------");
				
			}
			
			
		}while(choice!=7);
}

@SuppressWarnings("null")
void doct(String name,String id) {
	
	Scanner sc = new Scanner(System.in);
	int choice;
	String pid;
	System.out.println("*----------------------------------------*");
	System.out.println("  WELCOME TO E HEALTHCARE MANAGEMENT SYSTEM  ");
	System.out.println("\t\t"+name.toUpperCase());
	System.out.println("*----------------------------------------*");
	do {
		System.out.println("1.Patient Details");
		System.out.println("2.Insert Patient Records");
		System.out.println("3.Get a particular Patient Record");
		System.out.println("4.All patient Records");
		System.out.println("5.Exit");
		System.out.println("*----------------------------------------*");
		
		List<Patient> list1=new ArrayList<Patient>();
		Excelfile excel =new Excelfile();
		DoctorOperations pat=new DoctorOperations();
		CRUDOperations pati = new CRUDOperations();
		
		System.out.println("Choose the following options given below:");
		choice = sc.nextInt();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fDate = myDateObj.format(myFormatObj);
		String pres,diag;
		PatientRecord patii = null;
		Patient patt = null;
	
		String pname;
		
		String  age;
		String sex;
		String blood;
		switch(choice) {
		case 1:
			System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                    Patient Details               ");
			System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
			System.out.println(" Name       ID         AGE        SEX     BLOOD_GROUP   DIAGNOSIS   PRESCRIPTION");
			System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
			pati.getAllPatients();
			break;
		case 2:
			System.out.println("Enter patient Id");
			String PID = sc.next();
			System.out.println("Enter prescription:");
			pres=sc.next();
			System.out.println("Enter diagnosis: ");
			diag=sc.next();
			patii = new PatientRecord(pres,diag,fDate,PID);
		try {
				excel.patientDescUpdate(patii);
					
			}catch (Exception e) {
				
				e.getMessage();
				System.out.println("Exception");
			}
			System.out.println("Done");
			break;
		
		case 3:
			System.out.println("Enter patient id:");
			pid = sc.next();
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                                     ID NO :   "+pid+"    PATIENT RECORD                                              ");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("  Name        ID            AGE        GENDER         BLOOD_GROUP      DIAGNOSIS        PRESCRIPTION      ");
			patt = new Patient(pid,pid,pid,pid,pid);
			try {
			excel.patientrecorddetails(patt);
			}catch (Exception e) {
				
				e.getMessage();
				System.out.println("Exception");
			}
			
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			break;
		case 4:
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("  Name           ID              SEX            AGE           BLOOD_GROUP       Diagnosis        Prescription             ");
			
			pat.getAllRecord();
			
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			
			break;
		case 5:
			System.out.println("Thank you");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
				
		
		}
		
		
	}while(choice!=6);
	
}


}
		


public class Main {
	static Map<Integer,Doctor> map= new HashMap<Integer,Doctor>();
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static List<Doctor> doctors = new ArrayList<Doctor>();
	public static void main (String args[]) throws IOException{
		
		CRUDOperations crud=new CRUDOperations();
		DoctorOperations crud_=new DoctorOperations();
		Validation v = new Validation();
		Doctor doctor = null;
		first f = new first();
		
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fDate = myDateObj.format(myFormatObj);
		
		
		String usrname,password;
		String name,id;
		String  pres;
		String diag;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("E Helath care Mangement");
		System.out.println("1. Admin");
		System.out.println("2. Doctor");
		int choice = sc.nextInt();
		do {
		switch(choice) {
		case 1 :
			System.out.println("Enter username:");
			usrname=sc.next();
			System.out.println("Enter passsord:");
			password = sc.next();
			if(v.adminLogin(usrname, password))
			{
				System.out.println("Success");
				f.admin();
			}else
				System.out.println("Check your username and password");
		    System.out.println("*----------------------------------------*");
		    
			break;
		case 2:
			System.out.println("Enter doctor's name:");
			name = br.readLine();
			System.out.println("Enter doctor Id:");
			id = br.readLine();
			
			doctor = new Doctor(name,id);
			
			
			try {
				crud_.insert(doctor);
				
				
				
				
			}catch (Exception e) {
				
				e.getMessage();
			}
			f.doct(name,id);
			break;
		
		default:
			System.out.println("Invalid Choice");
		}	
			
		}while(choice!=3);
			
		
		
}
}




		
	

