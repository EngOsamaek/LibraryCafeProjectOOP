package Customer;

import FileOperations.FileReader;
import Library.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerLoginPage extends StackPane
{        boolean check;

    File file;
    Scanner scanner;
    String UN;
    BorderPane borderPane=new BorderPane();
    GridPane gridPane=new GridPane();
    GridPane userLoginPne = new GridPane();
    TextField username = new TextField();
    TextField password = new PasswordField();
    Button login=new Button("Login");
    FileReader fileReader = null;
    //Stage primaryStage;
    Scene scene;
    Button back=new Button("return");
    public static String customerID;
    CustomerLoginPage() throws FileNotFoundException {

    }

    public CustomerLoginPage(Stage primaryStage) throws FileNotFoundException {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.username.setText("ilhamHoca");
        this.password.setText("ilham123");
        userLoginPne.setPrefWidth(400);
        userLoginPne.add(username,0,0);
        userLoginPne.add(password,0,1);
        userLoginPne.add(login,0,3);
        login.setPrefWidth(100);
        userLoginPne.setHgap(20);
        userLoginPne.setVgap(10);
        userLoginPne.setPadding(new Insets(10,10,10,10));

        userLoginPne.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.add(back,0,0);
        borderPane.setRight(userLoginPne);
        borderPane.setLeft(gridPane);
        this.getChildren().addAll(borderPane);
        gridPane.setPrefWidth(450);
        gridPane.setPrefHeight(650);
        username.setPromptText("username");
        password.setPromptText("password");

        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText("The password is incorrect");
        userLoginPne.getStyleClass().add("topMenuManagement");
        username.getStyleClass().add("textField");
        password.getStyleClass().add("textField");
        login.getStyleClass().add("ManagerLoginButton");
        gridPane.getStyleClass().add("ManagerLoginLeftMenu");
        back.getStyleClass().add("ManagerReturnButton");
        username.setPromptText("Username");
        password.setPromptText("Password");
        login.setOnAction((e->{

            if (this.checkLogin(username.getText(),password.getText())){
                UN = username.getText();
                try {
                    new CustomerMainPage().start(primaryStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
            else {
                Label wrongenterence = new Label("Your username or password is wrong.");
                wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");
                userLoginPne.add(wrongenterence,0,4);

            }
        }));
        back.setOnAction(e->{
            try {
                new Main().start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    private boolean checkLogin(String username,String password){
        file=new File("src//Customer//Customer.txt");
        try {         new FileReader("customer");
            FileOperations.FileReader.customers.forEach(e->{
                if (username.compareTo(e.getUsername())==0 && password.compareTo(e.getPassword())==0){
                    customerID = e.getIDNum();
                    try {
                        new FileReader("Deposit");
                        for(Balance balance : FileReader.balances){
                            if(balance.getID().compareTo(customerID)==0){
                                CustomerMainPage.Balance.setText(balance.getBalance());
                            }
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    check=true;
                }

            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (check){
            return true;
        }
        return false;
    }

    String getUserName()
    {
        return UN;
    }


}
