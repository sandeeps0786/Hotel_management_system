package com.company;

public class Dish
{
    String dishName;
    double price;
    String dishType;

    public Dish(String dishName, double price, String dishType) {
        this.dishName = dishName;
        this.price = price;
        this.dishType = dishType;
    }
    Dish()
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

/*
class Dish
{
	public:
		string dishName;
		double price;
		string dishType;

	public:
		Dish(string dishName,double price,string dishType)
		{
			this->dishName=dishName;
			this->price=price;
			this->dishType=dishType;
		}
		Dish()
		{

		}
};
 */