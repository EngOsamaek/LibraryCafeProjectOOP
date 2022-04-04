package Cafe;

public class ToppingDecorator implements Coffee{

    protected Coffee tempCoffee;

    public ToppingDecorator(Coffee newCoffee){
        this.tempCoffee = newCoffee;
    }
    @Override
    public String getDescription() {
        return this.tempCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return this.tempCoffee.getCost();
    }

    @Override
    public Coffee getCopy() {
        return null;
    }
}
