package Interfaces;
import java.lang.*;
import Classes.*;

public interface IUserOperation
{
	boolean insertMeter(Meter a);
	boolean removeMeter(Meter a);
	Meter searchMeter(int MeterNumber);
	void showAllMeter();
	
}