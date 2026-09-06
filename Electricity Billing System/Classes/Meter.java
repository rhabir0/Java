package Classes;
import java.lang.*;


public abstract class Meter 
{   
	private int meterNumber;
	private String meterHolderName;
	private double meterReading;
	
	
	public Meter()
	{
		
	}
	public Meter(int meterNumber,String meterHolderName, double meterReading)
	{
		this.meterNumber=meterNumber;
		this.meterHolderName=meterHolderName;
		this.meterReading=meterReading;
		
	}
	public void setMeterNumber(int meterNumber)
	{
		this.meterNumber=meterNumber;
	}
	public int getMeterNumber()
	{
		return meterNumber;
	}
	public void setMeterHoldername()
	{
		this.meterHolderName=meterHolderName;
	}
	public String getMeterHolderName()
	{
		return meterHolderName;
	}
	public void setMeterReading(double meterReading)
	{
		this.meterReading=meterReading;
	}
	public double getMeterReading()
	{
		return meterReading;
	}
	
	public abstract void showDetails();
	
}