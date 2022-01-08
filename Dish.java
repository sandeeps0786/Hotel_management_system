package com.company;

public class Dish
{
    public String dishName;
    public double price;
    public String dishType;

    public Dish(String dishName, double price, String dishType) {
        this.dishName = dishName;
        this.price = price;
        this.dishType = dishType;
    }
    public Dish()
    {

    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", price=" + price +
                ", dishType='" + dishType + '\'' +
                '}';
    }
}

