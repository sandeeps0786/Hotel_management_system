package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Restaurant
{
    //-------------------------------------------------------------------SINGLETON
    static Restaurant restaurantObj = new Restaurant();
    Restaurant()
    {
    }
    public static Restaurant getInstanceOfClass()
    {
        return restaurantObj;
    }
    //-------------------------------------------------------------------SINGLETON
    List<Dish> dishes=new ArrayList<>();
    HashMap<String,ArrayList<String>> menu=new HashMap<>();
    Scanner scanner=new Scanner(System.in);
    int flag=1;
//    void addDishes()
//    {
//        for (int i = 0; i < 8; i++)
//        {
//            System.out.println(i+1+" Enter Dish Name Price and Type");
//            Dish dish=new Dish();
//            ArrayList<String> values=new ArrayList<>(2);
//            dish.dishName=scanner.next();
//            dish.price=scanner.nextDouble();
//            dish.dishType=scanner.next();
//
//            dishes.add(dish);
//            values.add(Double.toString(dish.price));
//            values.add(dish.dishType);
//
//            menu.put(dish.dishName,values);
//
//            System.out.println("If you want to add more dishes type 1 else 0");
//            flag=scanner.nextInt();
//            if(flag==0)
//                break;
//        }
//    }

    Dish getDish(String  dnam) {
        int i;
        for (i = 0; i <dishes.size(); i++) {
            if (dishes.get(i).dishName.equals(dnam)) {
                return dishes.get(i);
            }
        }
        return null;
    }

    void displayDish(Dish d)
    {
        System.out.println("Dish Namev:: "+d.dishName);
        System.out.println("Price:: "+d.price);
        System.out.println("Dish Type:: "+d.dishType);
    }

    void displayMenu()
    {
        for(int i=0;i<dishes.size();i++)
        {
            displayDish(dishes.get(i));
        }
    }
}
