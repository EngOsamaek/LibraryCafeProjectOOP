package Cafe;

import Cafe.Toppings.ExtraShot;
import Cafe.Toppings.Milk;
import Cafe.Toppings.Sugar;

public class CoffeeFactory {
    Coffee basicCoffee;
    getClone getClone = new getClone();
    public BasicCoffee makeCoffee(String milk, String sugar, String extraShot){
        if(milk.equals("Milk")&&sugar.equals("Sugar")&&extraShot.equals("ExtraShot")){

            basicCoffee = new Milk(new Sugar(new ExtraShot(new BasicCoffee())));


        }
        else if(milk.equals("Milk")&&sugar.equals("Sugar")&&extraShot.equals("None")){
            basicCoffee = new Milk(new Sugar(new BasicCoffee()));

        }
        else if(milk.equals("Milk")&&sugar.equals("None")&&extraShot.equals("None")){
           basicCoffee = new Milk((new BasicCoffee()));

        }
        else if(milk.equals("Milk")&&sugar.equals("None")&&extraShot.equals("None")){
            basicCoffee = new Milk((new BasicCoffee()));

        }
        else if(milk.equals("None")&&sugar.equals("Sugar")&&extraShot.equals("ExtraShot")){
            basicCoffee = new Sugar(new ExtraShot(new BasicCoffee()));

        }
        else if(milk.equals("None")&&sugar.equals("Sugar")&&extraShot.equals("None")){
            basicCoffee = new Sugar((new BasicCoffee()));

        }
        else if(milk.equals("None")&&sugar.equals("None")&&extraShot.equals("ExtraShot")){
            basicCoffee = new ExtraShot((new BasicCoffee()));

        }
        else{
            basicCoffee = new BasicCoffee();
        }
        return (BasicCoffee) getClone.getCoffee(basicCoffee);
    }
}
