package designPatterns.project;

import java.util.Scanner;

abstract class Customer
{
    public String custName;
    public String custAddress;
    public String custID;
    public long custPhone;
    public String custEmail;
    public String checkInTime;
    public int status;

    public Customer()
    {

        String dt=java.time.LocalTime.now().toString();
        this.custName=" ";
        this.custAddress =" ";
        this.custID =" ";
        this.custPhone = 0L;
        this.custEmail =" ";
        this.checkInTime = dt;
        status=0;
    }

    void setData()
    {
        Scanner sc=new Scanner(System.in);

        String dt=java.time.LocalTime.now().toString();
        this.checkInTime = dt;

        System.out.println("Enter your Name :\n");
        this.custName=sc.nextLine();

        System.out.println("Enter your Address :\n");
        this.custAddress=sc.nextLine();

        System.out.println("Enter your Phone number :\n");
        this.custPhone=sc.nextLong();

        System.out.println("Enter your Email :\n");
        this.custEmail=sc.nextLine();

    }

    int selectChoice()
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println(" Hello!\n");
        System.out.println("Enter \n1. Accomodation \n 2. Dine\n ");
        ch=sc.nextInt();
        return ch;
    }



    void printCustomer()
{
    System.out.println("Name :: "+this.custName);
    System.out.println("Address :: "+this.custAddress);
    System.out.println("ID :: " +custID);
    System.out.println("Phone Number :: "+ custPhone);
    System.out.println("Email :: "+custEmail);
    System.out.println("Check-In Time ::"+this.checkInTime);

}
    abstract void viewTotalBill();
    abstract void allocateRoom(Room r1);
    abstract void allocateDish(Dish d1);
    abstract void checkout();
}
