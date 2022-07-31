import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//Ask how many new user we want to add
		ArrayList<Student> students =new ArrayList<Student>();
		System.out.println("Enter number of new student to enroll");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		while(i>0) {
			Student student1 = new Student();
			student1.enroll(); 
			student1.payTuition();
			System.out.println(student1.toString());
			students.add(student1);
			i--;
		}
		for(int j =0  ;j<students.size();j++) {
			System.out.println(students.get(j).toString());
		}
				
		//create n number of new student 
		

	}

}
