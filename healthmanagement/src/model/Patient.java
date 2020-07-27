package model;
import java.util.*;
import java.io.*;
import dao.*;
public class Patient {

	private String name = "";
	private String pid="";
	private String age = "";
	private String sex="";
	private String blood="";

	
	
	public Patient(String name, String pid, String age, String sex, String blood) {
		
		this.name = name;
		this.pid = pid;
		this.age = age;
		this.sex = sex;
		this.blood = blood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	


}
