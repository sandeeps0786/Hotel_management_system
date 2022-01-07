// Strategy Interface

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


// Context class

class SelectEmployee
{
	protected Employee emp;
	
	public SelectEmployee(Employee emp)
	{
		this.emp=emp;
	}
	
	public void performDuty()
	{
		emp.performDuty();
	}
}


