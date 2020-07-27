package dao;
 import java.util.*;
 import model.*;
 import java.io.*;

 import org.apache.poi.poifs.filesystem.POIFSFileSystem;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
 public class Excelfile {
	 
	 static Workbook wb;
		static Sheet sh;
		static Row row;
		static Cell cell;
		static FileInputStream in;
		static FileOutputStream out;
		   int i=0;
//Insert Doctor details
 public void excelgenerator(Doctor doctor, List<Doctor> list) throws Exception {
				
				try {
					in = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\Doctordetails.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(in);
					XSSFSheet sheet = workbook.getSheetAt(0);
					int rowCount = sheet.getLastRowNum();
					 
					for(Doctor doctor1 :list) {
						 Row row = sheet.createRow(++rowCount);
						 int columnCount = 0;
						 Cell cell = row.createCell(columnCount);
						 cell.setCellValue(rowCount);
						 
						 row.createCell(0).setCellValue(doctor1.getDocName());
						 row.createCell(1).setCellValue(doctor1.getDocId());
						
					 	 }
					   
					out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\Doctordetails.xlsx"));
			        workbook.write(out);
			        out.close();
			                    
				    }catch (Exception e) {
				    	System.out.println(e.getMessage());
				    }
			}
		   
 
 
 
 
	//insert patient record details
 public void patientrecordgenerator(PatientRecord doctor, List<PatientRecord> list) throws IOException {
		
		try {
			in = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			 
			for(PatientRecord doctor1 :list) {
				 Row row = sheet.createRow(++rowCount);
				 int columnCount = 0;
				 Cell cell = row.createCell(columnCount);
				 cell.setCellValue(rowCount);
				 
				
				 row.createCell(0).setCellValue(doctor1.getPrescription());
				 row.createCell(1).setCellValue(doctor1.getDiagnosis()); 
				
				 row.createCell(2).setCellValue(doctor1.getTime());
				 
			 	 }
			
			
			out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx"));
	        workbook.write(out);
	        out.close();
	                    
		    }catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
	}
	
	
//Adding diagnosis and prescription to Patient Details. 
 @SuppressWarnings("unlikely-arg-type")
public void patientDescUpdate(PatientRecord patientrecord) throws Exception {
		try {
			System.out.println("start update");
			in = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			System.out.println("workbook created ");
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);
			for(int i=0;i<rowCount+1;i++) {
				Row row = sheet.getRow(i);
				if(row!=null) {
					Cell cell  = row.getCell(1);
					String id = cell.getStringCellValue();
					//System.out.println(patientrecord.getId()+ "." +cell.getStringCellValue()+".");
					if(id.equalsIgnoreCase(patientrecord.getId())) {
						//System.out.println("Inside IF");
						Cell cell5 = row.createCell(5);
							cell5.setCellValue(patientrecord.getPrescription());
						Cell cell6 = row.createCell(6);
							cell6.setCellValue(patientrecord.getDiagnosis());
							System.out.println("Success");
						break;
					}
				}
				else {
					continue;
				}
			}
		
			   
			out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx"));
	       workbook.write(out);
	       out.close();
	      }catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
	 }
		   
		   
//insert patient details
public void patientexcelinsert(Patient patient, List<Patient> list) throws Exception {
	try {
		in = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		for(Patient pat :list) {
			 Row row = sheet.createRow(++rowCount);
			 int columnCount = 0;
			 Cell cell = row.createCell(columnCount);
			 cell.setCellValue(rowCount);
			 
			 row.createCell(0).setCellValue(pat.getName());
			 row.createCell(1).setCellValue(pat.getPid());
			 row.createCell(2).setCellValue(pat.getAge());
			 row.createCell(3).setCellValue(pat.getSex());
			 row.createCell(4).setCellValue(pat.getBlood());
			 
		 	 }
		   
		out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx"));
       workbook.write(out);
       out.close();
      }catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
 }

//reads data in excel file.

	public void excelreader(String fname) {
		try
    {
        FileInputStream file = new FileInputStream(new File(fname));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
      int i=0;
        while (rowIterator.hasNext()) 
        {
            row = rowIterator.next();
            if(i!=1) {
            	 row = rowIterator.next();
            	 i++;
            }
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
             
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    
    }catch (Exception e) {
    	System.out.println(e.getMessage());
    }
		
	}
//delete item
	
	public void deleteitem(String id) {
		int rowIndex;
		try
	      {
			
	          FileInputStream file = new FileInputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\Doctordetails.xlsx"));
	          XSSFWorkbook workbook = new XSSFWorkbook(file);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          for (rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	        	  row = sheet.getRow(rowIndex);
	        	  if (row != null) {
	        		 
	        		  
	        	   Cell cell = row.getCell(1);
	       
	        	    String value=cell.getStringCellValue();
	        	    if (value.equals(id)) {
	        	    	System.out.println("Working 2");
	        	    	sheet.removeRow(sheet.getRow(rowIndex));
	        	    	//sheet.shiftRows(rowIndex+1,sheet.getLastRowNum(), -1);
	        	    	 System.out.println("Deleted Successfully!");
	        	    }
	        	  }
	        	}
	            out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\Doctordetails.xlsx"));
		        workbook.write(out);
		        out.close();
	     
	       }catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}
 
 
 //delete item patient
 public void deletepatientitem(String id) {
		try
	      {
			
	          FileInputStream file = new FileInputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx"));
	          XSSFWorkbook workbook = new XSSFWorkbook(file);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	        	  row = sheet.getRow(rowIndex);
	        	  System.out.println("Working 1");
	        	  if (row != null) {
	        		  
	        	    Cell cell = row.getCell(1);
	        	    String value=cell.getStringCellValue();
	        	   
	        	    if (value.equals(id)) {
	        	    	System.out.println("Working 2");
	        	    	sheet.removeRow(sheet.getRow(rowIndex));
	        	    	 
	        	    	 System.out.println("Deleted Successfully!");
	        	    }
	        	  }
	        	}
	            out = new FileOutputStream(new File("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx"));
		        workbook.write(out);
		        out.close();
	     
	       }catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}
//particular pateint details
	public void patientrecorddetails(Patient patient) throws Exception{
		try
	      {
	          in = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\healthmanagement\\PatientDetails.xlsx");
	          XSSFWorkbook workbook = new XSSFWorkbook(in);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          int rowCount = sheet.getLastRowNum();
	         // Iterator<Row> rowIterator = sheet.iterator();
	         // int flag=0;
	          for (i=0;i<rowCount+1;i++) {
	        	  row = sheet.getRow(i);
	        	  if (row != null) {
	        	    Cell cell = row.getCell(1);
	        	    String id = cell.getStringCellValue();
	        	    if(id.equalsIgnoreCase(patient.getPid()))
	        	    {
	        	    
	        	    	System.out.print(row.getCell(0).getStringCellValue()+"\t\t");//getStringCellValue() + "\t\t");
	        	    	System.out.print(row.getCell(1).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(2).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(3).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(4).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(5).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(6).getStringCellValue());
	        	    	
	        	   
	        	    }
	        	    
	        	    System.out.println("");
	        	    
	        	    }
	        	  }
	        	
	        in.close();
	      	}catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}
}

 
