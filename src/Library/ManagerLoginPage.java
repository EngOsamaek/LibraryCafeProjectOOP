package Library;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManagerLoginPage extends StackPane {
    File file;
    Scene scene;
    Scanner scanner;
    HBox topMenu = new HBox();
    Label topMenuText = new Label();
    GridPane mainPane = new GridPane();
    GridPane main2=new GridPane();
    TextField username = new TextField();
    PasswordField password = new PasswordField();
    Button login = new Button("Login");
    Button back=new Button("return");
    BorderPane borderPane=new BorderPane();
    public ManagerLoginPage(Stage primaryStage){
        this.username.setText("Osama");
        this.password.setText("Osama_2001");
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        mainPane.setAlignment(Pos.CENTER);
        mainPane.add(username,0,0);
        mainPane.add(password,0,1);
        mainPane.add(login,0,3);
        login.setPrefWidth(100);
        mainPane.setHgap(20);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10,10,10,10));
        login.setAlignment(Pos.CENTER);
        main2.setAlignment(Pos.TOP_LEFT);
        main2.add(back,0,0);
        borderPane.setLeft(main2);
        borderPane.setRight(mainPane);
        mainPane.setPrefWidth(400);
        main2.setPrefWidth(450);
        main2.setPrefHeight(650);
        mainPane.getStyleClass().add("topMenuManagement");
        borderPane.setTop(topMenu);
        username.getStyleClass().add("textField");
        password.getStyleClass().add("textField");
        login.getStyleClass().add("ManagerLoginButton");
        main2.getStyleClass().add("ManagerLoginLeftMenu");
        back.getStyleClass().add("ManagerReturnButton");
        username.setPromptText("Username");
        password.setPromptText("Password");
        this.getChildren().add(borderPane);



        back.setOnAction(e->{
            try {
                new Main().start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        login.setOnAction((e->{

            if (this.checkLogin(username.getText(),password.getText())){
                new ManagementMainPage().start(primaryStage);

            }
            else {
                Label wrongenterence = new Label("Your username or password is wrong.");
                wrongenterence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");
           mainPane.add(wrongenterence,0,4);
            }
        }));
    }
    private boolean checkLogin(String username,String password){
        file=new File("src//FileOperations//User.txt");
        try {
            scanner=new Scanner(file);
            while (scanner.hasNext()){
                if (username.compareTo(scanner.next())==0 && password.compareTo(scanner.next())==0){
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}




