package com.company;// Strategy Interface

public interface Employee {
	
	public void performDuty();
}


//Strategy Classes

class RoomService implements Employee
{
		public void performDuty()
		{
			System.out.println("Employee XYZ arriving at your doorstep...");
			System.out.println();
		}
}

class Waiter implements Employee
{
		public void performDuty()
		{
			System.out.println("Employee ABC arriving at your table to take your Order...");
			System.out.println();
		}
}



class SelectEmployee
{
	 Employee emp;
	
	public SelectEmployee(Employee emp)
	{
		this.emp=emp;
	}
	public SelectEmployee()
	{

	}
	
	public void performDuty()
	{
		emp.performDuty();
	}
}


