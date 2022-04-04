package Library;

import Customer.CustomerLoginPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class LandingPageE extends StackPane
{
    GridPane landingPage = new GridPane();
    Button admin = new Button("CUSTOMER");
    Button customer = new Button("CUSTOMER");
    Scene scene;
    HBox buttonBox = new HBox();
//    Stage stage;

    LandingPageE(Stage primaryStage)
    {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.getStyleClass().add("mainPage");
        admin.getStyleClass().add("mainPageButtonManagement");
        customer.getStyleClass().add("mainPageButtonCustomer");

        buttonBox.getChildren().addAll(admin,customer);

        landingPage.add(buttonBox,0,0);
        landingPage.setAlignment(Pos.CENTER);

        this.getChildren().addAll(landingPage);

        admin.setOnMouseClicked(e->{
            scene = new Scene(new ManagerLoginPage(primaryStage),850,650);
            //stage = new Stage();
            primaryStage.setScene(scene);

        });

        customer.setOnMouseClicked(e->{
            try {
                scene = new Scene(new CustomerLoginPage(primaryStage),850,650);


            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            //stage.setTitle("Library Cafe");
            primaryStage.setScene(scene);
        });
    }

}
