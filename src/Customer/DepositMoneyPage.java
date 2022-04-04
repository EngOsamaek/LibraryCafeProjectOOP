package Customer;

import FileOperations.FileReader;
import FileOperations.FileUpdater;
import Library.TextFieldConditions;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DepositMoneyPage extends GridPane {

    Label MoneyAmount = new Label("Amount of Money");
    Label CardNum = new Label("Card Number");
    TextField moneyAmountText = new TextField();
    TextField cardNumText = new TextField();
    Button Deposit = new Button("Deposit");
    public DepositMoneyPage() throws Exception{
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.getStyleClass().add("CustomerTopMenuBackground");
        MoneyAmount.getStyleClass().add("OrderPageLabel");
        moneyAmountText.getStyleClass().add("RegisterPageText");
        CardNum.getStyleClass().add("OrderPageLabel");
        cardNumText.getStyleClass().add("RegisterPageText");
        Deposit.getStyleClass().add("AddBookButton");
        this.setHgap(5);
        this.setVgap(5);

        this.setAlignment(Pos.CENTER);
        this.add(MoneyAmount,0,0);
        this.add(moneyAmountText,1,0);
        this.add(CardNum,0,1);
        this.add(cardNumText,1,1);
        this.add(Deposit,1,2);
        new TextFieldConditions(moneyAmountText);
        new TextFieldConditions(cardNumText);

        Deposit.setOnAction(e->{
            try {
                new FileReader("Deposit");
                for (Balance balance: FileReader.balances){
                    if(balance.getID().compareTo(CustomerLoginPage.customerID)==0){
                        double Balance = ((Double.parseDouble(balance.getBalance()))+(Double.parseDouble(moneyAmountText.getText())));
                        CustomerMainPage.Balance.setText(String.valueOf((Double.parseDouble(CustomerMainPage.Balance.getText())+Double.parseDouble(moneyAmountText.getText()))));
                        new FileUpdater(new Balance(CustomerLoginPage.customerID,String.valueOf(Balance)));
                    }
                    else{

                    }
                }



            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
