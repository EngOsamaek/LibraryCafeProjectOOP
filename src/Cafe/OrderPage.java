package Cafe;

import Customer.Balance;
import FileOperations.FileReader;
import FileOperations.FileUpdater;
import Library.TextFieldConditions;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class OrderPage extends GridPane {

    FileReader fileReader = new FileReader("customer");

    Label MilkLabel = new Label("Milk");
    Label SugarLabel = new Label("Sugar");
    Label ExtraShotLabel = new Label("ExtraShot");
    Label PaymentLabel = new Label("Payment Type");
    Label Cost = new Label("Cost");
    Label CostNumber = new Label();
    Label AccountID = new Label("Account ID");

    TextField accountID = new TextField();
    Label wrongenterence = new Label();

    ChoiceBox<String> Milk = new ChoiceBox<>();
    String milk[] = {"Milk", "None"};

    ChoiceBox<String> Sugar = new ChoiceBox<>();
    String sugar[] = {"Sugar", "None"};

    ChoiceBox<String> ExtraShot = new ChoiceBox<>();
    String extraShot[] = {"ExtraShot", "None"};

    ChoiceBox<String> PaymentType = new ChoiceBox<>();
    String payment[] = {"Cash", "CreditCard", "Account"};

    Button order = new Button("Order");

    public OrderPage() throws Exception {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.setVgap(10);
        this.setHgap(5);
        this.add(wrongenterence,0,8);


        Milk.getStyleClass().add("OrderPageChoice");
        Sugar.getStyleClass().add("OrderPageChoice");
        ExtraShot.getStyleClass().add("OrderPageChoice");
        PaymentType.getStyleClass().add("OrderPageChoice");
        order.getStyleClass().add("OrderPageButton");
        accountID.getStyleClass().add("OrderPageText");
        MilkLabel.getStyleClass().add("OrderPageLabel");
        SugarLabel.getStyleClass().add("OrderPageLabel");
        ExtraShotLabel.getStyleClass().add("OrderPageLabel");
        PaymentLabel.getStyleClass().add("OrderPageLabel");
        Cost.getStyleClass().add("OrderPageLabel");
        CostNumber.getStyleClass().add("OrderPageLabel");
        AccountID.getStyleClass().add("OrderPageLabel");


        new TextFieldConditions(accountID);
        this.setAlignment(Pos.CENTER);
        Milk.setItems(FXCollections.observableArrayList(milk));
        Sugar.setItems(FXCollections.observableArrayList(sugar));
        ExtraShot.setItems(FXCollections.observableArrayList(extraShot));
        PaymentType.setItems(FXCollections.observableArrayList(payment));
        CostNumber.setText("2");

        Milk.setOnAction(e -> {
            if (Milk.getValue().compareTo("Milk") == 0) {
                double costMoney = Double.parseDouble(CostNumber.getText()) + 0.5;
                CostNumber.setText(String.valueOf(costMoney));
            } else {
                double costMoney = Double.parseDouble(CostNumber.getText()) - 0.5;
                CostNumber.setText(String.valueOf(costMoney));
            }
        });
        ExtraShot.setOnAction(e -> {
            if (ExtraShot.getValue().compareTo("ExtraShot") == 0) {
                double costMoney = Double.parseDouble(CostNumber.getText()) + 1;
                CostNumber.setText(String.valueOf(costMoney));
            } else {
                double costMoney = Double.parseDouble(CostNumber.getText()) - 1;
                CostNumber.setText(String.valueOf(costMoney));
            }
        });

        this.add(MilkLabel, 0, 0);
        this.add(Milk, 1, 0);
        this.add(SugarLabel, 0, 1);
        this.add(Sugar, 1, 1);
        this.add(ExtraShotLabel, 0, 2);
        this.add(ExtraShot, 1, 2);
        this.add(PaymentLabel, 0, 3);
        this.add(PaymentType, 1, 3);
        this.add(order, 1, 4);
        this.add(Cost, 0, 6);
        this.add(CostNumber, 1, 6);

        PaymentType.setOnAction(e -> {
            if (PaymentType.getValue().compareTo("Account") == 0) {
                this.getChildren().remove(order);
                this.getChildren().remove(Cost);
                this.getChildren().remove(CostNumber);
                this.add(AccountID, 0, 4);
                this.add(accountID, 1, 4);
                this.add(order, 1, 5);
                this.add(Cost, 0, 7);
                this.add(CostNumber, 1, 7);
            } else {
                this.getChildren().remove(accountID);
                this.getChildren().remove(AccountID);
                this.getChildren().remove(order);
                this.getChildren().remove(Cost);
                this.getChildren().remove(CostNumber);
                this.add(order, 1, 4);
                this.add(Cost, 0, 6);
                this.add(CostNumber, 1, 6);
            }
        });


        order.setOnAction(e -> {
            try {
                new FileReader("Deposit");
                for (Balance balance : FileReader.balances) {
                    if (accountID.getText().compareTo(balance.getID()) == 0) {
                        if (Double.parseDouble(balance.getBalance()) < Double.parseDouble(CostNumber.getText())) {
                            this.wrongenterence.setText("You don't have money in your account");
                            wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");
                            break;

                        } else {
                            double total = Double.parseDouble(balance.getBalance()) - Double.parseDouble(CostNumber.getText());

                            new FileUpdater(new Balance(balance.getID(), String.valueOf(total)));

                    }
                }

if (Sugar.getValue()==null || Milk.getValue()==null || ExtraShot.getValue() == null || PaymentType.getValue()==null ){

    wrongenterence.setText("You should fill all the fields");
    wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

}
else {
    if (PaymentType.getValue().compareTo("Account")==0 && accountID.getText().isEmpty()){

        wrongenterence.setText("You should fill The account ID field");
        wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

    }
    else {
        CoffeeFactory factory = new CoffeeFactory();

        factory.makeCoffee(Milk.getValue(), Sugar.getValue(), ExtraShot.getValue());
        wrongenterence.setText(factory.basicCoffee.getDescription() + " " + factory.basicCoffee.getCost());
        wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");
    }}}} catch (Exception exception) {
        exception.printStackTrace();
    } });
    }


}
