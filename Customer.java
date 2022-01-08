package com.company;

import java.util.Scanner;

public abstract class Customer
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

        System.out.println("Enter your Name :");
        this.custName=sc.nextLine();
        System.out.println("customer Name:: "+this.custName);

        System.out.println("Enter your Address :");
        this.custAddress=sc.nextLine();
        System.out.println("customer Address :: "+this.custAddress);

        System.out.println("Enter your Phone number :");
        this.custPhone=sc.nextLong();
        System.out.println("custome Phone:: "+this.custPhone);

        System.out.println("Enter your Email :");
        this.custEmail= sc.next();
        System.out.println("customer email:: "+ this.custEmail);

    }

    int selectChoice()
    {
        Scanner sc=new Scanner(System.in);

        int ch;
        System.out.println(" Hello!");
        System.out.println("Enter 1. Accomodation  2. Dine");
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
