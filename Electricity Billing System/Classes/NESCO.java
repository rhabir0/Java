package Classes;
import java.lang.*;
import Interfaces.*;
public class NESCO implements INESCOP
{
	private User users[]= new User[100];
	
	public boolean insertUser(User c)
	{
		boolean flag = false;
		for(int i=0; i<users.length; i++)
		{
			if(users[i] == null)
			{
				users[i] = c;
				flag = true;
				System.out.println("Inserted");
				break;
			}
		}
		return flag;
	}
	
	public boolean removeUser(User c)
	{
		boolean flag = false;
		for(int i=0; i<users.length; i++)
		{
			if(users[i] == c)
			{
				users[i] = null;
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public User searchUser(int userId)
	{
		User c = null;
		
		for(int i=0; i<users.length; i++)
		{
			if(users[i] != null)
			{
				if(users[i].getUserId() == userId)
				{
					c = users[i];
					break;
				}
			}
		}
		return c;
	}
	public void showAllUser()
	{	
		for(int i=0; i<users.length; i++)
		{
			if(users[i] != null)
			{
				System.out.println("************************");
				users[i].showDetails();
				System.out.println();
			}
		}
	}
}