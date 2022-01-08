package com.company;

import java.util.Scanner;

public class Room {
    String roomType;
    int noOfBeds;
    double rent;
    int roomNo;
    int status;

    Scanner scanner = new Scanner(System.in);  //edited

    public Room(String roomType, int noOfBeds, double rent, int roomNo) {
        this.roomType = roomType;
        this.noOfBeds = noOfBeds;
        this.rent = rent;
        this.roomNo = roomNo;
        this.status = 0;

    }

    void setRoom() {
        System.out.println("Enter Room Type, No of beds, Rent, RoomNo");
        this.roomType = scanner.next();
        this.noOfBeds = scanner.nextInt();
        this.rent = scanner.nextDouble();
        this.roomNo = scanner.nextInt();
        this.status = 0;

    }

    //-------------------------------------------------------------------SINGLETON
//    static Room roomObj = new Room();  edited
    public Room() {
    }

    //    public static Room getInstanceOfClass()  edited
//    {
//        return roomObj;
//    }
    //-------------------------------------------------------------------SINGLETON
    boolean isVacant(Room r) {
        if (r.status == 1)
            return false;
        else
            return true;
    }

    void displayDetail() {
        System.out.println("Room Type :: " + this.roomType);
        System.out.println("Number of Beds :: " + this.noOfBeds);
        System.out.println("Rent :: " + this.rent);
        System.out.println("Room Number ::" + this.roomNo);
        if (this.status == 1)
            System.out.println(" Occupied ");
        else
            System.out.println("Vacant ");

    }

    void vacateRoom(int rno) {

        for (int i = 0; i < 6; i++) {
            if (this.roomNo == rno)
                this.status = 0;
        }
    }

    void displayAvailable(Room r[]) {
        for (int i = 0; i < 6; i++) {
            if (r[i].status == 0) {
                r[i].displayDetail();
            }
        }
    }
}
