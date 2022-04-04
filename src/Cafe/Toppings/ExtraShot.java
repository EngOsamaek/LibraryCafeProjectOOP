package Cafe.Toppings;

import Cafe.Coffee;
import Cafe.ToppingDecorator;

public class ExtraShot extends ToppingDecorator {


    public ExtraShot(Coffee newCoffee) {
        super(newCoffee);
    }
    public String getDescription(){
        return tempCoffee.getDescription()+" With ExtraShot";
    }
    public double getCost(){
        return tempCoffee.getCost()+1;
    }
}
