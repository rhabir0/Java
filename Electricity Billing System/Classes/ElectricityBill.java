package Classes;
import java.lang.*;
import Interfaces.*;
public class ElectricityBill extends Meter implements IElectricityBillOperations
{
	private double firstRate=5.72;
	private double secondRate=6;
	private double thirdRate=6.34;
	private double fourthRate=9.94;
	private double fifthRate=11.46;
	private double result;
	protected double bill;
	
	
	public ElectricityBill()
	{
		
	}
	public ElectricityBill(int meterNumber,String meterHolderName, double meterReading)
	{
		super(meterNumber,meterHolderName,meterReading);
		
		
	}
	
	public double getBill()
	{
		return bill;
	}
	public double BillOperation()
	{
		
		
		
			if(getMeterReading()>76 && getMeterReading()<=200)
			{
				return result=firstRate*getMeterReading();
			
			}
			else if(getMeterReading()>201 && getMeterReading()<=300)
			{
				return result=secondRate*getMeterReading();
			
			}
				else if(getMeterReading()>301 && getMeterReading()<=400)
			{
				return result=thirdRate*getMeterReading();
			
			}
				else if(getMeterReading()>401 && getMeterReading()<=600)
			{
				return result=fourthRate*getMeterReading();
			
			}
			else if(getMeterReading()>600)
			{
				return result=fifthRate*getMeterReading();	
			}
			else
			{
				return result=250;	
			}
			
    }
	
		
		
	
	public void showDetails()
	{
		System.out.println("Bill Name is: "+getMeterHolderName());
		System.out.println("Meter Id: "+getMeterNumber());
		System.out.println("Unit is: "+getMeterReading());
		System.out.println("Your Electricity bill is: "+BillOperation()+"Tk");
	}
	public boolean AfterPayment(double amount)
	{
		bill=result;
		boolean flag = false;
		if(amount>0 && amount<=bill)
		{
			bill = bill - amount;
			flag = true;
		}
		
		return flag;
	}
	
}