package universityRegsiter;

import java.util.ArrayList;

public interface Department {

	void printDepartInfo();
	int getId();
	int createStudentUID();
	String GetDepatmentID();
	String toString();

	void setCourse(Cource cource);
	void setStudnetOnLevel(Student st);
	void RegistarStudentCourses();
	void DeleteStudentCourses();
	public Student Search(String setnumber , int level);
	public ArrayList <Student> getLevle1();
	public ArrayList <Student> getLevle2();
	public ArrayList <Student> getLevle3();
	public ArrayList <Student> getLevle4();
	public void modifyStudnetData();
}