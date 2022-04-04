package Library;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
    
    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Scene scene = new Scene(new LandingPageE(primaryStage),850,650);
            primaryStage.setTitle("Library Cafe");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public void screenShape(Stage stage){

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        }
    
        public static void main(String[] args) {
            launch(args);

        }
    }
