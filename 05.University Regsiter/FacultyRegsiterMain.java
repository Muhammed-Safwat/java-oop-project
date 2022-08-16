package universityRegsiter;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyRegsiterMain {
 	
	public static void main(String[] args) {
			
			Scanner input  = new Scanner(System.in);
			Faculty faculty =new Faculty();	
			UniversityMenu(input , faculty);
	       
	}
	
	
	 private static void UniversityMenu(Scanner input ,Faculty faculty) {
		int choise ;
		do {
			System.out.println("Choise what you want :");
			System.out.println("1) Add student");
			System.out.println("2) Add course");
			System.out.println("3) Registar course for student");
			System.out.println("4) Drop course for Student ");
			System.out.println("5) Modifay a student registration ");
			System.out.println("6) Exsit");
			choise = input .nextInt();
		}while(choise<1 || choise>8);
		
		// make function which user choise 
		switch (choise) {
			case 1: 
				{
					SudentBilder sb =new SudentBilder(faculty);
					UniversityMenu(input ,faculty);
					break;
				} 
			case 2 : 
				{
					CourseBuilder cb =new CourseBuilder(faculty);
					UniversityMenu(input ,faculty);
					break;
				}
			case 3 :
				{
					System.out.println("Enter department :");
					faculty.printDepartmentsList();
					int d = input.nextInt();
					if(d==1) {
						faculty.departments.get(0).RegistarStudentCourses();
						UniversityMenu(input ,faculty);
					}else if(d==2){
						faculty.departments.get(1).RegistarStudentCourses();
						UniversityMenu(input ,faculty);
					}else {
						System.err.println("unValid choise");
						UniversityMenu(input ,faculty);
					}	
				}
			case 4 : 
			{
				System.out.println("Enter department :");
				faculty.printDepartmentsList();
				int d = input.nextInt();
				if(d==1) {
					faculty.departments.get(0).DeleteStudentCourses();
					UniversityMenu(input ,faculty);
				}else if(d==2){
					faculty.departments.get(1).DeleteStudentCourses();
					UniversityMenu(input ,faculty);
				}else {
					System.err.println("unValid choise");
					UniversityMenu(input ,faculty);
				} 
				
			}
			case 5 :
			{
				System.out.println("Enter department :");
				faculty.printDepartmentsList();
				int d = input.nextInt();
				if(d==1) {
					faculty.departments.get(0).modifyStudnetData();
					UniversityMenu(input ,faculty);
				}else if(d==2){
					faculty.departments.get(1).modifyStudnetData();
					UniversityMenu(input ,faculty);
				}else {
					System.err.println("unValid choise");
					UniversityMenu(input ,faculty);
				} 
			}
		
		}

		} 
}
