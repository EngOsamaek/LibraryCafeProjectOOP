package Customer;

import FileOperations.FileReader;
import Library.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CustomerMainPage extends Application {
    ArrayList<Filter> arrayList;
    Button back = new Button();
    Button ShowBookButton = new Button();
    Button Deposit = new Button();
    Button Notifications = new Button("Notifications");
    VBox leftMenu = new VBox();
    StackPane topMenu = new StackPane();
    HBox topMenNodes = new HBox();
    HBox topMenuLabel = new HBox();
    StackPane firstEnterPage = new StackPane();
    BorderPane mainPagePane = new BorderPane();

    public static Label Balance = new Label();
    Label BalanceText = new Label("Balance: ");

    Label label = new Label();
    Label tMenuLabel = new Label("LIBRARY CAFE SYSTEM");
    GridPane notificationPane = new GridPane();
    Label notificationLabel = new Label("Newly Available Books");
    int i;

    public void start(Stage stage) throws Exception {


        mainPagePane.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        back.getStyleClass().add("CustomerMainPageButtons");
        ShowBookButton.getStyleClass().add("CustomerMainPageButtons");
        Deposit.getStyleClass().add("CustomerMainPageButtons");
        topMenu.getStyleClass().add("CustomerTopMenuBackground");
        leftMenu.getStyleClass().add("CustomerLeftMenuBackground");
        Notifications.getStyleClass().add("CustomerMainPageButtons");
        notificationPane.getStyleClass().add("NotificationPane");
        notificationLabel.getStyleClass().add("CustomerNotifLabel");
        BalanceText.getStyleClass().add("CustomerNotifLabel");
        Balance.getStyleClass().add("CustomerNotifLabel");
        tMenuLabel.getStyleClass().add("LibraryCafeLabel");
        label.getStyleClass().add("CustomerNotifLabel");

        topMenNodes.getChildren().addAll(BalanceText,Balance);
        topMenNodes.setAlignment(Pos.BOTTOM_RIGHT);
        topMenuLabel.getChildren().add(tMenuLabel);
        topMenuLabel.setAlignment(Pos.TOP_LEFT);
        topMenuLabel.setPadding(new Insets(10,10,10,10));

        topMenu.getChildren().addAll(topMenNodes,topMenuLabel);

        mainPagePane.setCenter(firstEnterPage);
        notificationPane.setVgap(10);
        notificationPane.setAlignment(Pos.TOP_CENTER);
        ShowBookButton.setText("Search Book");
        Deposit.setText("Deposit");
        back.setText("Return");

        leftMenu.setPrefWidth(100);
        topMenu.setPrefHeight(100);

        leftMenu.getChildren().addAll(Notifications,ShowBookButton, Deposit, back);
        mainPagePane.setLeft(leftMenu);

        mainPagePane.setTop(topMenu);


        new FileReader("Notification");
        for (String notif : FileReader.notifications) {
            label.setText(label.getText() + "\n" + notif);
        }
        notificationPane.add(notificationLabel,0,0);
        notificationPane.add(label,0,1);
        firstEnterPage.getChildren().add(notificationPane);
        back.setOnAction(e -> {
            try {
                new Main().start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        mainPagePane.setCenter(firstEnterPage);
        Scene scene = new Scene(mainPagePane, 850, 650);
        stage.setScene(scene);
        Notifications.setOnAction(e->{
            mainPagePane.setCenter(firstEnterPage);
        });
        ShowBookButton.setOnAction(e -> {

            mainPagePane.setCenter(new CustomerFilterBooks());

        });
        Deposit.setOnAction(e -> {
            try {
                mainPagePane.setCenter(new DepositMoneyPage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }

    public void screenShape(Stage stage) {

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }


}


