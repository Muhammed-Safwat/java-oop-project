package universityRegsiter;

import java.util.Scanner;

public class SudentBilder {
	Scanner input = new Scanner(System.in);
	
	public SudentBilder(Faculty faculty){
		Student student = new Student();
		SetStudnetData(student  , input);
		SetDepartmet(faculty ,student  , input);
		setGrade(student);
		createId(student); 
		generateSetNumber(student);
		setStudnetAtDepart(faculty , student);
		student.StudnetData();
	}
	
	
	public void createId(Student student) {
		student.setUID(student.getStudentdepart().createStudentUID());
	}
	
	public void setGrade(Student student) {
		student.setGrade(1);
	}
	// generate set number 
	public void generateSetNumber(Student student) {
		String setNum ; 
		int g = student.getGrade();
		int dId =student.getStudentdepart().getId();
		int sId =student.getUID();
		setNum=dId+"0"+g+"0"+sId;
		student.setSetNumber(setNum);
	}
	
	public void TestStudnet(Student st) {
		System.out.println(st.getName());
		System.out.println(st.getNationalID());
		System.out.println(st.getAddress());
		System.out.println(st.getEmail());
		System.out.println(st.getPhoneNumber());
		System.out.println(st.getGrade());
		System.out.println(st.getUID());
		System.out.println(st.getCompletedCourses());
	}
	
	// * get name, email , address , phone number form user *//
	///* regex **/
	public void SetStudnetData(Student student  ,Scanner input) {
		System.out.println("Enter full name :");
		String name =input.nextLine();
		student.setName(name);
		System.out.println("Enter student email (example@gmail.com) :");
		String email =input.nextLine();
		student.setEmail(email);
		System.out.println("Enter student national  id :");
		String id =input.nextLine();
		student.setNationalID(id);
		System.out.println("Enter student address :");
		String address =input.nextLine();
		student.setAddress(address);
		System.out.println("Enter student phone number :");
		String phone =input.nextLine();
		student.setPhoneNumber(phone);
		
	}
	public void SetDepartmet(Faculty faculty ,Student student , Scanner input) {
		System.out.println("Choise department :");
		faculty.printDepartmentsList();
		int x = input .nextInt()-1;
		Department depart = faculty.departments.get(x);
		student.setStudentdepart(depart);
	}
	
	public void setStudnetAtDepart(Faculty faculty ,Student studnet) {
		int id = studnet.getStudentdepart().getId();
		for(Department d : faculty.departments) {
			if(d.getId() == id) {
				d.setStudnetOnLevel(studnet);
				break;
				}
				
			}
		}
	
	 

}
