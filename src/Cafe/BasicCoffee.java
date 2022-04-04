package Cafe;

public class BasicCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Filter Coffee";
    }

    @Override
    public double getCost() {
        return 2.00;
    }

    @Override
    public Coffee getCopy() {
        BasicCoffee coffee = null;
        try {
            coffee = (BasicCoffee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return coffee;
    }

}
