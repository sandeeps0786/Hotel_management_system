package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {

        int ch,i,o,ch1,ch2,r,rno,rcount=0,dcount=0;
        Room r2;
        String dname;
        Dish d2;

        Scanner sc=new Scanner(System.in);


        Hotel Tajhotel=new Hotel();


        ArrayList<Dish> d=new ArrayList<Dish>();


        d.add(new Dish("Chocolate_Fondue",140.0,"Desert"));
        d.add(new Dish("Manchow_Soup",110.0,"Soup"));
        d.add(new Dish("Shahi_paneer",220.0,"Main course"));
        d.add(new Dish("Arizona_Tea",100.0,"Beverage"));
        d.add(new Dish("Grilled_Romaine Salad",180.0,"Salad"));
        d.add(new Dish("Mushroom_Manchurian",170.0,"Starter"));
        d.add(new Dish("Pina_Colada",210.0,"Cocktail"));
        d.add(new Dish("Raspberry_Ripple",120.0,"Ice Cream"));



        ArrayList<Customer> customer=new ArrayList<Customer>();
        Restaurant res=new Restaurant();


        for(i=0;i<d.size();i++)
        {
            res.dishes.add(d.get(i));        // shows types of dishes present in the hotel
        }

        Tajhotel.restaurant=res;                  //Tajhotel restaurant now have the previous restaurant dishes



        ArrayList<Room> rm=new ArrayList<Room>();                          // adding different kind of room in array later we will push it into tajhotel room
        rm.add(new Room("Deluxe",2,3500,1));
        rm.add(new Room("AC",1,5500,2));
        rm.add(new Room("Non AC",2,2500,3));
        rm.add(new Room("AC",2,3500,4));
        rm.add(new Room("Deluxe",2,3500,5));
        rm.add(new Room("Deluxe",3,4500,6));

        SelectEmployee e=new SelectEmployee();                             // for the room service

        Tajhotel.setHotel(res,rm);                      // all the room set into tajhotel room





        while(true)
        {

            for(i=0;i<5;i++)
            {
                int level=2;

                while(true)
                {
                    if(level==1)
                    {
                        System.out.println("Enter 1. To Display Rooms 2. To Book a Room 3. To Vacate Room 4. To Get Invoice  5. Not Satisfied? 6. Cancel Booking 7. Give Feedback 8. Back");

                        ch1=sc.nextInt();

                        switch (ch1)
                        {
                            case 1:Tajhotel.displayAvailble();
                                level=1;break;
                            case 2:
                                if(Tajhotel.customers.get(i).status==1)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.print("Sorry! You Cannot Book more than one room!");
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                }
                                else
                                {
                                    Tajhotel.customers.get(i).status=1;
                                    Tajhotel.displayAvailble();
                                    System.out.println("Enter Room No");
                                    rno=sc.nextInt();
                                    Tajhotel.bookRoom(rno);
                                    r2=Tajhotel.getRoom(rno);
                                    Tajhotel.customers.get(i).allocateRoom(r2);
                                }

                                level=1;break;
                            case 3:
                                if(Tajhotel.customers.get(i).status!=1)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.print("Cannot Vacate a Room unless booked");
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();

                                }
                                else
                                {
                                    Tajhotel.customers.get(i).status=0;
                                    System.out.println("Enter Room No");
                                    rno= sc.nextInt();
                                    Tajhotel.vacateRoom(rno);
                                    System.out.println("Room Vacated!");
                                }

                                level=1;break;
                            case 4:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("Cannot get Invoice Details unless You book a Room");
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                }
                                else
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    Tajhotel.customers.get(i).printCustomer();
                                    Tajhotel.customers.get(i).viewTotalBill();
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();

                                    level=1;break;

                                }
                            case 5:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("Cannot call Room Service unless You book a Room");
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                }
                                else
                                {
                                    e=new SelectEmployee(new RoomService());
                                    e.performDuty();
                                }
                                level=1;break;
                            case 6:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("No Room Booked");
                                }
                                else
                                {
                                    Tajhotel.customers.get(i).status=0;
                                    System.out.println("Enter room no");
                                    rno= sc.nextInt();
                                    Tajhotel.vacateRoom(rno);
                                    System.out.println("Cancellation Successful!");
                                }
                                level=1;break;
                            case 7:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("Cannot Give feedback unless you order a Dish");
                                }
                                else
                                {
                                    Tajhotel.askFeedback();
                                }
                                level=1;break;
                            case 8: level=2;break;
                        }
                    }
                    else if(level==2)
                    {
                        System.out.println("Enter 1. Accomadation 2. Restaurant 3. Exit");
                        ch=sc.nextInt();
                        if(ch==1) {
                            Tajhotel.customers.add(new RoomCustomer());
                            Tajhotel.generateID(Tajhotel.customers.get(i));
                            System.out.println("Enter Your Details");
                            Tajhotel.customers.get(i).setData();
                            System.out.println("Enter 1. To Display Rooms 2. To Book a Room 3. To Vacate Room 4. To Get Invoice  5. Not Satisfied? 6. Cancel Booking 7. Give Feedback 8. Back");

                            ch1=sc.nextInt();

                            switch (ch1)
                            {
                                case 1:Tajhotel.displayAvailble();
                                    level=1;break;
                                case 2:
                                    if(Tajhotel.customers.get(i).status==1)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.print("Sorry! You Cannot Book more than one room!");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        Tajhotel.customers.get(i).status=1;
                                        Tajhotel.displayAvailble();
                                        System.out.println("Enter Room No\n");
                                        rno=sc.nextInt();
                                        Tajhotel.bookRoom(rno);
                                        r2=Tajhotel.getRoom(rno);
                                        Tajhotel.customers.get(i).allocateRoom(r2);
                                    }

                                    level=1;break;
                                case 3:
                                    if(Tajhotel.customers.get(i).status!=1)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.print("Cannot Vacate a Room unless booked");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        Tajhotel.customers.get(i).status=0;
                                        System.out.println("Enter Room No");
                                        rno= sc.nextInt();
                                        Tajhotel.vacateRoom(rno);
                                        System.out.println("Room Vacated!");
                                    }

                                    level=1;break;
                                case 4:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("Cannot get Invoice Details unless You book a Room");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        Tajhotel.customers.get(i).printCustomer();
                                        Tajhotel.customers.get(i).viewTotalBill();
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();

                                        level=1;break;

                                    }
                                case 5:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("Cannot call Room Service unless You book a Room");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        e=new SelectEmployee(new RoomService());
                                        e.performDuty();
                                    }
                                    level=1;break;
                                case 6:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("No Room Booked");
                                    }
                                    else
                                    {
                                        Tajhotel.customers.get(i).status=0;
                                        System.out.println("Enter room no");
                                        rno= sc.nextInt();
                                        Tajhotel.vacateRoom(rno);
                                        System.out.println("Cancellation Successful!");
                                    }
                                    level=1;break;
                                case 7:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("Cannot Give feedback unless you order a Dish");
                                    }
                                    else
                                    {
                                        Tajhotel.askFeedback();
                                    }
                                    level=1;break;
                                case 8: level=2;break;
                            }

                        }
                        else if(ch==2)
                        {
                            Tajhotel.customers.add(new RestaurantCustomer());
                            Tajhotel.generateID(Tajhotel.customers.get(i));
                            System.out.println("Enter you Detail");
                            Tajhotel.customers.get(i).setData();

                            level3:System.out.print("Enter 1. To display Menu 2. To order a Dish 3. To Get Invoice 4. To Cancel Order 5. Give FeedBack 6. Go back");
                            ch2=sc.nextInt();

                            switch (ch2)
                            {

                                case 1:
                                    Tajhotel.displayMenu();
                                    level=3;break;

                                case 2:
                                    if(Tajhotel.customers.get(i).status==1)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("You cannot order more than one dish");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();

                                    }
                                    else
                                    {
                                        o=1;
                                        Tajhotel.customers.get(i).status=1;
                                        Tajhotel.displayMenu();
                                        e=new SelectEmployee(new Waiter());
                                        e.performDuty();
                                        System.out.println("Enter Dish Name you want to Order(Make sure you enter the exact same name");
                                        dname=sc.next();
                                        Tajhotel.takeOrder(dname);
                                        d2=Tajhotel.restaurant.getDish(dname);
                                        Tajhotel.customers.get(i).allocateDish(d2);

                                        if(o==0)
                                        {
                                            System.out.println("-----------------------------------------------------------------------------------------");
                                            System.out.println();
                                            System.out.println("No such Dish Found");

                                        }

                                    }
                                    level=3;break;
                                case 3:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("Cannot get invoice Details unless you order a dish");
                                    }
                                    else
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        Tajhotel.customers.get(i).printCustomer();
                                        Tajhotel.customers.get(i).viewTotalBill();
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                    level=3;break;

                                case 4:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("No Dish Ordered");
                                    }
                                    else
                                    {
                                        Tajhotel.customers.get(i).status=0;
                                        System.out.println("Cancellation successfull");
                                    }
                                case 5:
                                    if(Tajhotel.customers.get(i).status==0)
                                    {

                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("Cannot Give Feedback unless you order a dish");
                                    }

                                    Tajhotel.askFeedback();
                                    level=1;break;
                                case 6:
                                    level=2;break;
                            }




                        }
                        else if(ch==3)
                        {
                            return;
                        }
                        else
                        {
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("Invalid Input");
                        }
                        level=2;

                    }
                    else if(level==3)
                    {
                        System.out.println("Enter 1. To display Menu 2. To order a Dish 3. To Get Invoice 4. To Cancel Order 5. Give FeedBack 6. Go back");
                        ch2=sc.nextInt();

                        switch (ch2)
                        {

                            case 1:
                                Tajhotel.displayMenu();
                                level=3;break;

                            case 2:
                                if(Tajhotel.customers.get(i).status==1)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("You cannot order more than one dish");

                                    System.out.println();
                                    System.out.println("-----------------------------------------------------------------------------------------");

                                }
                                else
                                {
                                    o=1;
                                    Tajhotel.customers.get(i).status=1;
                                    Tajhotel.displayMenu();
                                    e=new SelectEmployee(new Waiter());
                                    e.performDuty();
                                    System.out.println("Enter Dish Name you want to Order(Make sure you enter the exact same name");
                                    dname=sc.next();
                                    Tajhotel.takeOrder(dname);
                                    d2=Tajhotel.restaurant.getDish(dname);
                                    Tajhotel.customers.get(i).allocateDish(d2);

                                    if(o==0)
                                    {
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("No such Dish Found");

                                    }

                                }
                                level=3;break;
                            case 3:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("Cannot get invoice Details unless you order a dish");
                                }
                                else
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    Tajhotel.customers.get(i).printCustomer();
                                    Tajhotel.customers.get(i).viewTotalBill();
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                }
                                level=3;break;

                            case 4:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("No Dish Ordered");
                                }
                                else
                                {
                                    Tajhotel.customers.get(i).status=0;
                                    System.out.println("Cancellation successfull");
                                }
                                level=1;break;
                            case 5:
                                if(Tajhotel.customers.get(i).status==0)
                                {
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("Cannot Give Feedback unless you order a dish");
                                }

                                Tajhotel.askFeedback();
                                level=1;break;
                            case 6:
                                level=2;break;
                        }

                    }
                }


            }

        }







    }






}
