package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hotel {
    private static Hotel instance;
    private String hotelName;
    private String hotelAddress;
    public Restaurant restaurant;
    public List<Room> room = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();
    public List<Employee> employee = new ArrayList<>();

    public Hotel() {

    }

    //    private static final Hotel INSTANCE = new Hotel("CRESCENT","HUBLI");  //edit
    public static Hotel getInstance() {
        return instance;
    }


    public static void setInstance(Hotel instance) {
        Hotel.instance = instance;
    }



    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Room> getRoom() {
        return room;
    }


    public static synchronized Hotel getHotel(){
        if(instance == null){
            instance = new Hotel("TAJHOTEL","MUMBAI");
        }
        return instance;
    }

    protected Hotel(String Hotelname, String address)
    {
        this.hotelName=Hotelname;
        this.hotelAddress=address;
    }

    public void setHotel(Restaurant r,List<Room> rs){
//        System.out.println(rs.size());
//        System.out.println(r.dishes.size());
        int roomsize=rs.size();
        int dishsize=r.dishes.size();
        for(int i=0;i<roomsize;i++){
           this.room.add(rs.get(i));
        }
        for(int i=0;i<dishsize;i++){
            this.restaurant.dishes.add(r.dishes.get(i));
        }
    }

    public void generateID(Customer c){
        String id = String.valueOf(new Random().nextInt(1000));
        c.custID=id;

    }
    public Room getRoom(int rno){
        for(int i=0;i<room.size();i++){
            if(room.get(i).roomNo == rno){
                return room.get(i);
            }
        }
        return null;
    }
    public void displayAvailble(){
        System.out.println("---------------------------------------------Room Details----------------------------------------------");
        System.out.println("Room Type"+"  "+"Number of Beds"+"  "+"Rent"+"  "+"Room Number");
        for(int i=0;i<room.size();i++){
            if(room.get(i).status ==0){
                System.out.println(room.get(i).roomType+"     "+room.get(i).noOfBeds+"     "+room.get(i).rent+"     "+room.get(i).roomNo);
            }
        }
    }

    public void displayMenu(){
        System.out.println("----------------------------------------------Menu-------------------------------------------------");
        System.out.println("Dish Name"+"     "+"Price"+"     "+"Dish Type");
        for(Dish d: restaurant.dishes){
            System.out.println(d.dishName+"     "+d.price+"     "+d.dishType);
        }
    }

    public void bookRoom(int r){
        for(Room room:room){
            if(room.roomNo==r){
                room.status=1;
            }
        }
    }
    public void vacateRoom(int rno){
        int j=0;
        for(Room room:room){
            if(room.roomNo==rno){
                j=1;
                room.status=0;
                System.out.println("Thank You! Visit Again.");
                break;
            }
        }
        if(j==0){
            System.out.println("Sorry Room not found, or occupied at the moment");
        }
    }

    public void takeOrder(String dnm){
        int j=0;
        for(Dish d:restaurant.dishes){
            if(d.dishName.equalsIgnoreCase(dnm)){
                j=1;
                System.out.println("Order Successful");
                break;
            }
        }
        if(j==0){
            System.out.println("Sorry! Dish Not Found, Enter a valid entry");
        }
    }

    void getCustomerData(Customer c)
    {
        System.out.println("Name :: "+c.custName);
        System.out.println("Address :: "+c.custAddress);
        System.out.println("phone :: "+c.custPhone);
        System.out.println("Email :: "+c.custPhone);
        System.out.println("Check-In Time :: "+c.checkInTime);
    }

     void askFeedback()
     {}

}
