package universityRegsiter;

import java.sql.Time;
import java.util.Scanner;
 
public class Cource {
	
	private static int id =1; 
	private String uuid ; 
	private String name ; 
	private String major ;
	private int cridHour ; 
	private int grade ;
	private int courseMarks ; 
	Scanner input = new Scanner(System.in);
	
	// constractor
	public Cource(){
		id++;
	}
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Cource.id = id;
	}

	public String getMajor() {
		return major;
	}
 
	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getCourseMarks() {
		return courseMarks;
	}
	
	public void setCourseMarks(int courseMarks) {
		this.courseMarks = courseMarks;
	}
	
	public int getCridHour() {
		return cridHour;
	}
	
	public void setCridHour(int cridHour) {
		this.cridHour = cridHour;
	}
	
	public void printCourseInfo(){
		 System.out.println("Cource name : "+this.getName());
		 System.out.println("Cource id   : "+this.getUuid()+", Major : "+this.getMajor());
		 System.out.println("Cource cridet hour : "+this.getCridHour()+", Total grade : "+this.getGrade());
	}
	
}
