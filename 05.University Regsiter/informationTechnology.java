package universityRegsiter;

import java.util.ArrayList;
import java.util.Scanner;

public class informationTechnology implements Department {
	
	public final String DepatmentID="IT";
	private final int id = 2 ;
	private int studnetsId;
	private ArrayList<Student> level1; 
	private ArrayList <Student> level2; 
	private ArrayList <Student> level3; 
	private ArrayList <Student> level4; 
	private ArrayList <Cource>  cources;
	
	Scanner input = new Scanner(System.in);
	
	informationTechnology(){
		
		level1  = new ArrayList<Student>();
		level2  = new ArrayList<Student>();
		level3  = new ArrayList<Student>();
		level4  = new ArrayList<Student>();
		cources = new ArrayList();
		studnetsId=600;
	}
	
	@Override
	public void printDepartInfo() {
		System.out.println(this.id+") Information Technology ("+this.DepatmentID+")");	
	}

	@Override
	public int getId() {
		return this.id ;
	}
	
	@Override
	public String GetDepatmentID() {
		return this.DepatmentID;
	}
	
	@Override 
	public void setCourse(Cource cource) {
		this.cources.add(cource);
	}
 
	public int createStudentUID() {
		return this.studnetsId++;
	}
	
	public String toString() {
		return "Information Technology";
	}
	
	public void  showStudentList() {
		System.out.println("**** level one student ****");
		for(Student i : level1 ) {
			i.StudnetData();
		}
		System.out.println("***************************");
		for(Student i : level2 ) {
			i.StudnetData();
		}
		System.out.println("***************************");
		for(Student i : level3 ) {
			i.StudnetData();
		}
		System.out.println("***************************");
		for(Student i : level4 ) {
			i.StudnetData();
		}
	}


	public void setOnLevel1(Student st) {
		level1.add(st);
	}

	public void setOnLevel2(Student st) {
		level2.add(st);
	}

	public void setOnLevel3(Student st) {
		level3.add(st);
	}

	public void setOnLevel4(Student st) {
		level4.add(st);
	}

	@Override
	public void setStudnetOnLevel(Student st) {
		int level = st.getGrade();
		switch (level) {
			case 1:{
				setOnLevel1(st);
				break;
			}
			case 2:{
				setOnLevel2(st);		
				break;
			}
			case 3:{
				setOnLevel3(st);
				break;
			}
			case 4:{
				setOnLevel4(st);
				break;
			}
		}
		
	}
	   // Registar stundent courses 
			@Override
			public void RegistarStudentCourses() {
				    Scanner input = new Scanner(System.in)  ;
					System.out.println("Enter Studnet name :");
					 String name ="" ; 
					 name =  input.nextLine();
					 System.out.println("Enter Studnet set number :");
					 String setnumber ; 
					 setnumber = input.nextLine();
					 System.out.println("Enter Studnet level :");
					 int level ; 
					 level = input.nextInt();
					 printCourseToStudnet(setnumber ,  level);   
				}
				 
			// search for student in his level 
			public Student Search(String setnumber , int level) {
				
				if(level == 1) {
				   for(Student s : level1)	{
					   if(s.getSetNumber().equalsIgnoreCase(setnumber)) { 
						   return s;
					   }
				   }
				}else if (level == 2) {
					   for(Student s : level2)	{
						   if(s.getSetNumber().equalsIgnoreCase(setnumber)) {
							   return s;
						   }
					   }
				}else if (level == 3) {
					   for(Student s : level3)	{
						   if(s.getSetNumber().equalsIgnoreCase(setnumber)) {
							   return s;
						   }
					   }
				}else if (level == 4) {
					   for(Student s : level4)	{
						   if(s.getSetNumber().equalsIgnoreCase(setnumber)) {
							   return s;
						   }
					   }
				} 
			return null;
		 }
		
		 public void printCourseToStudnet(String setnumber , int level) {
				 
			 Student  studnet = Search( setnumber ,  level);
				//if studnet is found  
				if( studnet != null) {
					 // print only unrolled cources in department ;
					   System.out.println("un rolled cources for student");
					   for(Cource c : this.cources) {
						   	ArrayList<Cource>  courses = studnet.getUnCompletedCourses();
					   	    // if first time for studnet courses number is zero all department cources is avilable 
							   	if(courses.size()==0) {
							   		System.out.println("************");
							   	    c.printCourseInfo();
							   	}
						   	// if studnet compleate any cources 
							   	for(int i =0 ;i<courses.size();i++) {
									   if(courses.get(i).equals(c)) {
										   continue;
									   }else {
										   System.out.println("************");
										   c.printCourseInfo();
									   }
							   	}
					   	}
					   registercourse(studnet);
					   

				}else {
					StudnetNotFound();
				}
				 
		 }
		 
	    public void StudnetNotFound() {
			System.err.println("studnet not found");
			System.out.println("1:enter student info again");
			System.out.println("2:exsit");
			int x = input.nextInt();
			if(x==1) {
				RegistarStudentCourses();
			}
	    }
	    
	    public void registercourse(Student studnet) {
	    	// add course for studnet 
			 System.out.println("Enter Course code to Register");
			 String courceuuid = input.nextLine();
			 boolean a = true;
			  for(Cource course : this.cources) {
				  if(course.getUuid().equals(courceuuid)) {
					 studnet.getUnCompletedCourses().add(course);
					 System.out.println(course.getName()+" course add succssuflly to studnet "+studnet.getName() );
					 a=false;
				  }
				  
			  }	
			  if(a) {System.err.println("non Valid cources id");}
	    }

		@Override
		public ArrayList <Student> getLevle1() {
			// TODO Auto-generated method stub
			return level1;
		}
		
		@Override
		public ArrayList <Student> getLevle2() {
			// TODO Auto-generated method stub
			return this.level2;
		}
		
		@Override
		public ArrayList <Student> getLevle3() {
			// TODO Auto-generated method stub
			return this.level3;
		}
		
		@Override
		public ArrayList <Student> getLevle4() {
			// TODO Auto-generated method stub
			return this.level4;
		}
		
		
		/*
		 *   modify student data 
		 * 	 Name nationalID email address phoneNumber ;
		 */
		
		@Override
		public void modifyStudnetData() {
		 	 Scanner input = new Scanner(System.in)  ;
			 System.out.println("Enter Studnet name :");
			 String name ="" ; 
			 name =  input.nextLine();
			 System.out.println("Enter Studnet set number :");
			 String setnumber ; 
			 setnumber = input.nextLine();
			 System.out.println("Enter Studnet level :");
			 int level ; 
			 level = input.nextInt();
			 Student student = Search(setnumber ,  level);
			 if(student==null) {
				 System.err.println("studnet not found !");
			 }else {
				getDataToModifay(student);
				student.StudnetData();
			 }

		}
		
		// get data form user 
		public void getDataToModifay(Student student) {
			System.out.println("chosise what you want to modify ");
			System.out.println("1) Name ");
			System.out.println("2) National ID ");
			System.out.println("3) Email ");
			System.out.println("4) Address ");
			System.out.println("5) Phone Number ");
			int x = input.nextInt();
			
			 
			switch(x) {
				case 1 :
					{
						System.out.println("Enter full name :");
						input.nextLine();
						String name =input.nextLine();
						System.out.println(x);
						student.setName(name);
						break;
					}
				case 2 : 
					{
						System.out.println("Enter student national  id :");
						input.nextLine();
						String id =input.nextLine();
						student.setNationalID(id);
						break;
					}
				case 3 :
					{
						System.out.println("Enter student email (example@gmail.com) :");
						input.nextLine();
						String email =input.nextLine();
						student.setEmail(email);
						break;
					}
				case 4 : 
				{
					System.out.println("Enter student address :");
					input.nextLine();
					String address =input.nextLine();
					student.setAddress(address);
					break;
				}
				case 5 :
				{
					System.out.println("Enter student phone number :");
					input.nextLine();
					String phone =input.nextLine();
					student.setPhoneNumber(phone);
					break;
				}
				default:{
					System.err.println("unValid choise");
					break;
				}
			}
			
		}
		
		public void DeleteStudentCourses() {
			 System.out.println("Enter Studnet name :");
			 String name ="" ; 
			 name =  input.nextLine();
			 System.out.println("Enter Studnet set number :");
			 String setnumber ; 
			 setnumber = input.nextLine();
			 System.out.println("Enter Studnet level :");
			 int level ; 
			 level = input.nextInt();
			 Student  studnet = Search( setnumber ,  level);
			 if(studnet==null) {
				 System.err.println("invalied set number");
			 }else {
				 for(Cource c : studnet.getUnCompletedCourses()) {
					 c.printCourseInfo();
				 }
				 DeleteCourse(studnet);
			 }
		}
		
		
		public void DeleteCourse(Student  studnet){
			System.out.println("Enter course id");
			input.nextLine();
			String id = input.nextLine();
			for(Cource c : studnet.getUnCompletedCourses()) {
				 if(c.getUuid().equals(id)) {
					 studnet.getUnCompletedCourses().remove(c);
					 System.out.println(c.getName()+" this course deleted");
					 break;
				 }
			 }
		}
}
 
