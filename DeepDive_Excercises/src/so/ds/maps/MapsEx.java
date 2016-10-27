package so.ds.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class MapsEx {

	static Map<Integer, Item> scart = new HashMap<Integer, Item>();
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice=5;
		System.out.println("MainMenu\n 1.Add\n 2.Modify\n 3.Remove\n 4.PrintBill\n 5.Exit");
		choice=input.nextInt();
		while(choice<5)
		{
		
		
			switch(choice)
			{
			case 1:addInMap();break;
			//case 2:modifyInMap();break;
			//case 3:removeFromMap();break;
			//case 4:printBill();break;
			case 5:break;		
			}
			
			System.out.println("MainMenu\n 1.Add\n 2.Modify\n 3.Remove\n 4.PrintBill\n 5.Exit");
			choice=input.nextInt();
		}
		
	}
	private static void addInMap() 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter Itemno:");
		int itemno=input.nextInt();
		System.out.println("Enter Itemname:");
		String itemname=input.next();
		System.out.println("Enter Qty:");
		int qty=input.nextInt();
		System.out.println("Enter Price:");
		int price=input.nextInt();
		
		Item x=new Item(itemno,qty,price,itemname);
		scart.put(x.getItemno(), x);	
		
	}

}
