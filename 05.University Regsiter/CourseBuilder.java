package universityRegsiter;

import java.util.Scanner;

public class CourseBuilder {
	
	Scanner input = new Scanner(System.in);
	CourseBuilder(Faculty faculty){
		createCource(faculty);
	}
	public void createCource(Faculty faculty) {
		Cource cource = new Cource();
		// set name course name 
		setName(cource);
		// set cridHour 
		setCridHour(cource);
		// set marks 
	    setMark(cource);
		// set grade 
	    setGrade(cource);
		// set major 
		setMajor(cource);
		// generate uuid for course 
		SetCourceUUid(cource);
		// enroll cource in faculty 
	    SetCourceOnDepartment(faculty ,cource);
	    // print cource content
	    cource.printCourseInfo();
	    
	}
	// set name 
	public void setName(Cource cource) {
		System.out.println("Enter course name");
		String name = input.nextLine();
		cource.setName(name);
	}
	
	public String generateCourseUUID(Cource cource) {
		String uuid ; 
		if(cource.getMajor().equals("CS")) {
			uuid= "CS0"+cource.getGrade()+""+cource.getId();
		}else {
			uuid= "IT0"+cource.getGrade()+""+cource.getId();
		}
		return uuid;
	}
	
	public void SetCourceUUid(Cource cource) {
		cource.setUuid(generateCourseUUID(cource));
	}
	
	public int getMajor() {
		int major;
		do {
			System.out.printf("Enter department\n1)CS  2)IT\n");
			major = input.nextInt();
			System.out.println(major);
		}while(major!=1 && major!=2);
		
		return major;
	}
	
	// set department 
	public void setMajor(Cource cource) {
		int major = getMajor();
		if(major==1) {
			cource.setMajor("CS");
		}else if(major==2) {
			cource.setMajor("IT");
		}else {
			System.out.println("error , unvalid department");
		}
	}
	
	// set cource hour 
	public void setCridHour(Cource cource) {
		System.out.println("Enter course cridet hour");
		int cridhour = input.nextInt();
		cource.setCridHour(cridhour);
	}
	
	// set mark  
	public void setMark(Cource cource) {
		System.out.println("Enter course marks on total");
		int mark = input.nextInt();
		cource.setCridHour(mark);
	}
	
	// set grade 
	public void setGrade(Cource cource) {
		System.out.println("Enter course grade");
		int grade = input.nextInt();
		cource.setGrade(grade);
	}

	public void SetCourceOnDepartment(Faculty faculty , Cource cource) {
		  String mj = cource.getMajor();
		for(Department f  : faculty.departments ) {
			System.out.println(cource.getMajor());
			if(f.GetDepatmentID()==cource.getMajor()) {
				f.setCourse(cource);
			}else if(f.GetDepatmentID()==cource.getMajor()) {
				f.setCourse(cource);
			}
		}
	}

}
