package universityRegsiter;

import java.util.ArrayList;
import java.util.Random;

public class Student {
	//user data in collage 
	private int UID;
	private String setNumber ; 
	private int grade ;
	// user personal data 
	private String Name ;
	private String nationalID;
	private String email ;
	//contact list
	private String address ;
	private String phoneNumber ;
	
	private Department  Studentdepart;
	private ArrayList<Cource> UnCompletedCourses ;
	private ArrayList<Cource> CompletedCourses ;
	
	public Student(){
		System.out.println("init cources");
		this.UnCompletedCourses=new ArrayList<Cource>();
		this.CompletedCourses=new ArrayList<Cource>();
	}
	
		
	public void setStudentdepart(Department studentdepart) {
		this.Studentdepart = studentdepart;
	}

	public int getUID() {
		return UID;
	}


	public void setUID(int uID) {
		UID = uID;
	}


	public String getNationalID() {
		return nationalID;
	}


	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}


	public String getSetNumber() {
		return setNumber;
	}



	public void setSetNumber(String setNumber) {
		this.setNumber = setNumber;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Department getStudentdepart() {
		return this.Studentdepart;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public ArrayList<Cource> getUnCompletedCourses() {
		return UnCompletedCourses;
	}






	public void setUnCompletedCourses(ArrayList<Cource> unCompletedCourses) {
		UnCompletedCourses = unCompletedCourses;
	}


	public ArrayList<Cource> getCompletedCourses() {
		return CompletedCourses;
	}


	public void setCompletedCourses(ArrayList<Cource> completedCourses) {
		CompletedCourses = completedCourses;
	}
	public void  StudnetData() {
		System.out.println("Name :"+this.Name);
		System.out.print("Setnumber :"+this.setNumber);
		System.out.println(", Grade :"+this.grade);
		System.out.println("Department :"+this.Studentdepart.toString());
		if(this.CompletedCourses.size()>0) {
			System.out.println("**************************");
			System.out.println("Completed cources list ");
			for(Cource c : this.CompletedCourses) {
				System.out.println(c);
			}
		}
		if(this.UnCompletedCourses.size()>0) {
			System.out.println("**************************");
			System.out.println("uncompleted cources list ");
			for(Cource c : this.UnCompletedCourses) {
				System.out.println(c);
			}
		}
	}
	
}
