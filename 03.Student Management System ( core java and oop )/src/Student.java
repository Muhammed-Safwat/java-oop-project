import java.util.Scanner;

public class Student {
	private String fristName ; 
	private String lastName ; 
	private int gradeYear ; 
	private String studentID ; 
	private String  courses =""; 
	private int tuitionBalance =0; 
	private static int costOfCourse = 600 ;
	private static int id = 1000;
	
	
	// constructor prompt user to enter students'name and year 
		public Student() {
			 
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter student first name:");
			this.fristName=input.nextLine();
			
			System.out.println("Enter student last name:");
			this.lastName=input.nextLine();
			
			System.out.println("1- Freshmen\n2- Sophmore\n3- Junior\n4- senior\nEnter Student class level:");
			this.gradeYear=input.nextInt();
			
			setStudentID();
			
			System.out.println(this.fristName +" "+ this.lastName +" "+this.studentID);
		}
	// generate an id 
	
		private void setStudentID() {
			// Greade +id 
			id++;
			this.studentID =  gradeYear+""+id;
		}
	
	// enroll in courses 
		public void enroll() {
			// Get inside a loop , user hits 0 
		String course="";
		do {
			System.out.println("Enter course to enroll (Q to exsit):");
			Scanner input = new Scanner(System.in);
			course =  input.nextLine();
			if(!course.equals("Q")) {
				courses =courses+"\n"+course;
				tuitionBalance+=costOfCourse;
			}else {
				break;
			}
			 
		}while(!course.equals("Q"));
			System.out.println("Enrolled in "+ courses);
			System.out.println("Tuition balance  "+ tuitionBalance);
		}
	
	// view balance 
		public void viewBalance() {
			System.out.println("Your balance id :$"+tuitionBalance);	
		}
	
	// pay tuition 
		public void payTuition() {
			int payment;
			viewBalance();
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your payment of : $ ");
			payment = input.nextInt();
			tuitionBalance = tuitionBalance - payment;
			System.out.println("Thank you for your payment of $ "+ payment);
			viewBalance();
		}
	
	// show status 
	public String toString() {
		return "   ******************************   "
				+"\nName:"+fristName+" "+lastName +
				"\nStudent ID : "+studentID+
				"\nGrade level: "+gradeYear+
				"\nCourses Enrolled:"+courses+
				"\nBalance: $"+tuitionBalance;
	}

}
