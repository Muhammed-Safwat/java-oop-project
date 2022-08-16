package universityRegsiter;

import java.util.ArrayList;
import java.util.Random;

public class Faculty {
   
	ArrayList <Department> departments = new ArrayList<Department>() ; 
   
	// init faculty 
   Faculty(){
	   computerScience cs = new computerScience();
	   informationTechnology it = new informationTechnology();
	   departments.add(cs);
	   departments.add(it);
   }
  
  public void printDepartmentsList() {
	  for(Department d : departments) {
		 d.printDepartInfo();
	  }
  }

}
