package threetier.emp;



public class Presentation 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			choice = menu1();
			
			doMenu1Job(choice);
		} while (choice != 0); // exit is done	
	}
	
	private static void doMenu1Job(int choice) 
	{
		// TODO Auto-generated method stub
		
		if (choice == 1)
			findpeople();
		
		
		
		
		
	}
	private static void findpeople() {
		// TODO Auto-generated method stub
		Integer deptid = InterfaceUtility.getNumber("DeptID");
		SI s =new SIIR();
		s.getEmp(deptid);
	}

	private static int menu1() {
		// TODO Auto-generated method stub
		
		String options =
			"\n 1. Select DeptID" +
			"\n 0. Exit";
		return InterfaceUtility.getNumber(options);
	}

}


