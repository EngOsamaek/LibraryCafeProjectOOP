package Cafe.Toppings;

import Cafe.Coffee;
import Cafe.ToppingDecorator;

public class Sugar extends ToppingDecorator {


    public Sugar(Coffee newCoffee) {
        super(newCoffee);
    }
    public String getDescription(){
        return tempCoffee.getDescription()+" With Sugar";
    }
    public double getCost(){
        return tempCoffee.getCost()+0;
    }
}

