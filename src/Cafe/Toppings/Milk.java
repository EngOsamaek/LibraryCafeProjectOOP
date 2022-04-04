package Cafe.Toppings;

import Cafe.Coffee;
import Cafe.ToppingDecorator;

public class Milk extends ToppingDecorator {


    public Milk(Coffee newCoffee) {
        super(newCoffee);
    }
    public String getDescription(){
        return tempCoffee.getDescription()+" With Milk";
    }
    public double getCost(){
        return tempCoffee.getCost()+0.5;
    }
}
