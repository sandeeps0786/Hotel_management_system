package com.company;
class RestaurantCustomer extends Customer
{

    public double dbill;
    public Dish d;
    public int orderStatus;


    public void viewTotalbill()
    {
        System.out.println("Bill ="+dbill);
    }

    void allocateDish(Dish d1)
    {
        this.d=d1;
    }

    @Override
    void checkout() {

    }

    void printCustomer()
    {

        super.printCustomer();
        if(orderStatus==1)
        {
            System.out.println("Dish Name :: "+d.dishName);
            System.out.println("Dish Type :: "+d.dishType);

        }
    }
    void viewTotalBill()
    {
        this.dbill=d.price;
        System.out.println("Bill :: "+this.dbill);
    }

    @Override
    void allocateRoom(Room r1) {

    }

}
