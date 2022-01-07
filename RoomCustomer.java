package designPatterns.project;


class RoomCustomer extends Customer
{
    public double rbill;
    public Room r;
    public int bookStatus;
    public void viewTotalbill()
    {
        System.out.println("Bill ="+rbill);        }

    public void allocateRoom(Room r1)
    {
        this.r=r1;
    }

    @Override
    void allocateDish(Dish d1) {

    }

    @Override
    void checkout() {

    }

    public void printCustomer()
    {

        super.printCustomer();
        if(r.status==1 && bookStatus==1)

        {
            System.out.println("Check-In Time :: "+checkInTime);
            System.out.println("Room type :: "+r.roomType);
            System.out.println("Room Number :: "+r.roomNo);
        }
    }
    void viewTotalBill()
    {
        this.rbill=r.rent;
        System.out.println("Bill :: "+this.rbill);
    }
    void checkOut()
    {
        System.out.println("Your bill is "+this.rbill+"/-");
        this.rbill=0;
        this.r.status=0;
        System.out.println("Thank You! Visit Again.");
    }


}
