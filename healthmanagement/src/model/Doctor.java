package model;
import dao.*;
import java.util.Set;
public class Doctor{
	
	private String docName;
	private String docId;

	
	
	
	
	
	
	
	public Doctor(String docName, String docId) {
		super();
		this.docName = docName;
		this.docId = docId;
		
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
	
 

 

	
}
