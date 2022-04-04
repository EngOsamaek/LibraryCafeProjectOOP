package Library;

import Cafe.OrderPage;
import FileOperations.RegistrationPage;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ManagementMainPage extends Application {
    VBox leftMenu = new VBox();
    HBox topMenu = new HBox();
    Scene scene;
    Button Order=new Button("Order");
    BorderPane mainPagePane = new BorderPane();
    Button back=new Button("Return");
    Button register=new Button("Register");
    Button AddBookButton = new Button("Add Book");
    Button SearchBookButton = new Button("Search Book");
    Button DeliverBookButton = new Button("Deliver Book");
    Button ReTakeBookButton = new Button("Retake Book");
    HBox topMenuLabel = new HBox();
    Label tMenuLabel = new Label("LIBRARY CAFE SYSTEM");
    public void start(Stage stage){
        mainPagePane.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        mainPagePane.getStyleClass().add("ManagerPageBackground");
        AddBookButton.getStyleClass().add("ManagerPageButtons");
        SearchBookButton.getStyleClass().add("ManagerPageButtons");
        DeliverBookButton.getStyleClass().add("ManagerPageButtons");
        ReTakeBookButton.getStyleClass().add("ManagerPageButtons");
        back.getStyleClass().add("ManagerPageButtons");
        Order.getStyleClass().add("ManagerPageButtons");
        register.getStyleClass().add("ManagerPageButtons");
        leftMenu.getStyleClass().add("ManagerPageLeftMenu");
        topMenu.getStyleClass().add("ManagerPageTopMenu");
        leftMenu.setPrefWidth(100);
        leftMenu.getChildren().addAll(AddBookButton,SearchBookButton,DeliverBookButton,ReTakeBookButton,Order,register,back);
        topMenu.setPrefHeight(100);
        tMenuLabel.getStyleClass().add("LibraryCafeLabel");
        topMenuLabel.getChildren().add(tMenuLabel);
        topMenu.getChildren().add(topMenuLabel);
        mainPagePane.setTop(topMenu);
        mainPagePane.setLeft(leftMenu);
         stage.setScene(new Scene(mainPagePane,850,650));



         AddBookButton.setOnAction(e->{
             mainPagePane.setCenter(new AddBookPage());
         });
         SearchBookButton.setOnAction(e->{
             mainPagePane.setCenter(new SearchBookPage());
         });
         DeliverBookButton.setOnAction(e->{
             mainPagePane.setCenter(new DeliveringBookE());
         });
         ReTakeBookButton.setOnAction(e->{
             try {
                 mainPagePane.setCenter(new ReTakenPage());
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });
         register.setOnAction(e->{
            mainPagePane.setCenter( new RegistrationPage(new Stage()));
         });
         back.setOnAction(e->{
             try {
                 new Main().start(stage);
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         });
        Order.setOnAction(e->{
            try {
                mainPagePane.setCenter(new OrderPage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void screenShape(Stage stage){

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }


}