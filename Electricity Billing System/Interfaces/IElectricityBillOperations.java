package Interfaces;
import java.lang.*;


public interface IElectricityBillOperations
{
	public abstract void showDetails();
	public abstract boolean AfterPayment(double amount);
}