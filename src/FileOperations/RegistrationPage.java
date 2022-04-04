package FileOperations;

import Library.Main;
import Library.TextFieldConditions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RegistrationPage extends StackPane {
    Main a = new Main();
    Button button = new Button("Registration");
    GridPane gridPane = new GridPane();
    TextField firstName = new TextField();
    TextField lastName = new TextField();
    TextField number = new TextField();
    TextField userName = new TextField();
    TextField password = new PasswordField();
    TextField IdentitiyNum = new TextField();
    TextField email = new TextField();
    Button register = new Button("Register");
    Label numberLabel = new Label();
    Label passwordLabel = new Label();
    Label nameLabel = new Label();
    Label lastname = new Label();
    Label emailLabel = new Label();
    Scene scene;
    boolean em;

    public RegistrationPage(Stage primaryStage) {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        firstName.getStyleClass().add("RegisterPageText");
        lastName.getStyleClass().add("RegisterPageText");
        number.getStyleClass().add("RegisterPageText");
        userName.getStyleClass().add("RegisterPageText");
        password.getStyleClass().add("RegisterPageText");
        email.getStyleClass().add("RegisterPageText");
        firstName.getStyleClass().add("RegisterPageText");
        register.getStyleClass().add("RegisterPageButton");
        IdentitiyNum.getStyleClass().add("RegisterPageText");

        gridPane.add(firstName, 0, 0);
        gridPane.add(lastName, 0, 1);
        gridPane.add(number, 0, 2);
        gridPane.add(userName, 0, 3);
        gridPane.add(password, 0, 4);
        gridPane.add(email, 0, 5);
        gridPane.add(register, 0, 7);
        gridPane.add(passwordLabel, 1, 4);
        gridPane.add(numberLabel, 1, 2);
        gridPane.add(nameLabel, 1, 0);
        gridPane.add(IdentitiyNum, 0, 6);
        gridPane.add(emailLabel, 1, 5);
        Label wrongsentence=new Label();
        this.gridPane.add(wrongsentence,0,9);

        this.getChildren().addAll(gridPane);
        firstName.setPromptText("First Name");
        lastName.setPromptText("Last Name");
        number.setPromptText("Number");
        userName.setPromptText("Username");
        password.setPromptText("Password");
        email.setPromptText("Email");
        number.setText("05");
        this.IdentitiyNum.setPromptText("ID number");
        firstName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (int i = 0; i < firstName.getText().length(); i++) {
                    if (!Character.isAlphabetic(firstName.getText().charAt(i))) {
                        firstName.setText(newValue.replace(String.valueOf(firstName.getText().charAt(i)), ""));
                        nameLabel.setText("The name should just contains letters");
                        nameLabel.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                    } else nameLabel.setText("");
                }
            }
        });
        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                em = false;
                for (int i = 0; i < email.getText().length(); i++) {
                    if (email.getText().charAt(i) == '@') {
                        em = true;
                        emailLabel.setText("");
                        break;
                    }
                    if (!em) {
                        emailLabel.setText("You should Enter a real Email");
                        emailLabel.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                    }
                }
            }
        });


        lastName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (int i = 0; i < lastName.getText().length(); i++) {
                    if (!Character.isAlphabetic(lastName.getText().charAt(i))) {
                        lastName.setText(newValue.replace(String.valueOf(lastName.getText().charAt(i)), ""));
                        lastname.setText("The last name should just contain letters");
                        lastname.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");
                    } else lastname.setText("");
                }
            }
        });


        new TextFieldConditions(number);
        new TextFieldConditions(IdentitiyNum);
        number.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (number.getText().length() > 10) {
                    number.setText(newValue.replace(number.getCharacters(), number.getCharacters().subSequence(0, 11)));
                }
                if (number.getText().length() < 2) {
                    number.setText(newValue.replace(String.valueOf(number.getCharacters()), "05"));
                }
                if (number.getText().length() < 11) {
                    numberLabel.setText("Number should contain 10 digits");
                    numberLabel.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                } else {
                    numberLabel.setText("");
                }
            }

        });

        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (password.getText().length() > 16) {
                    password.setText(newValue.replace(password.getCharacters(), password.getCharacters().subSequence(0, 16)));
                }
                if (password.getText().length() < 8) {
                    passwordLabel.setText("The password digits should >8 and password digits  <16 ");
                    passwordLabel.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                } else passwordLabel.setText("");
            }

        });


        //a.alert = new Alert(Alert.AlertType.ERROR);

        register.setOnAction((e -> {

            UserRegistration user = new UserRegistration();
            user.firstName = firstName.getText();
            user.lastName = lastName.getText();
            user.number = number.getText();
            user.email = email.getText();
            user.username = userName.getText();
            user.password = password.getText();
            user.IDNum = IdentitiyNum.getText();
            try {
                String notes;
                notes=user.checkEmployeeInfo(user);
                if (notes == null) {
                    user.addToFile(user);
                    user.MoneyRecordPage();
                    wrongsentence.setText("The info been added");
                    wrongsentence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                }
                else {
                    wrongsentence.setText(notes);
                    wrongsentence.setStyle("-fx-text-fill:lavender; -fx-font-size:15px; -fx-font-family:'Regular'; -fx-font-style:italic");

                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }));

    }
}


