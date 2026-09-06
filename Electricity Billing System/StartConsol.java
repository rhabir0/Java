import java.lang.*;
import Classes.*;
import Fileio.*;
import Interfaces.*;
import java.util.Scanner;
import java.io.*;
public class StartConsol
{
	public static void main(String args[])
	{
		Scanner input= new Scanner(System.in);
		NESCO eb= new ElectricityBill();
		User u=new User();
		ElectricityBill n= new NESCO();
		FileReadWriteDemo frwd=new FileReadWriteDemo();
		System.out.println("********************");
		

		{
			System.out.println("Here is your option:");
			System.out.println("\t1. User Management");
			System.out.println("\t2. User Bill Mangement");
			System.out.println("\t3. Bill Pyament and slip");
			System.out.println("\t4. Exit");
			
			System.out.println();
			System.out.print("Please select your option: ");
			int option = input.nextInt();
			
			switch(option)
			{
				case 1:
					System.out.println("_________________________________________________");
					System.out.println("You have chose User Management");
					System.out.println("_________________________________________________");
					
					System.out.println();
					System.out.println("You have the following options:");
					System.out.println("\t1. Register New user");
					System.out.println("\t2. Remove Existing user");
					System.out.println("\t3. Search an user");
					System.out.println("\t4. Show All user");
					System.out.println("\t5. Go Back");
					
					System.out.println();
					System.out.print("Enter you option: ");
					int option1 = input.nextInt();
					switch(option1)
					{
						case 1:
							System.out.println("____________________________________________");
							System.out.println("You have chose to Register New User");
							System.out.println("____________________________________________");
							
							System.out.print("Enter User ID: ");
							int userid1 = input.nextInt();
							System.out.print("Enter User Name: ");
							input.nextLine();
							String name1 = input.nextLine();
							
							
							User c1 = new User(userid1, name1);
							
							if(eb.insertUser(c1))
							{
								System.out.println("User " + c1.getUserId() + " has been Inserted");
							}
							else
							{
								System.out.println("User " + c1.getUserId() + " Can NOT be Inserted");
							}
							System.out.println();
							break;
							
						
					}					
			}	





	
