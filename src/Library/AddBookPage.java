package Library;

import Customer.Customer;
import FileOperations.FileWriter;
import Library.Observer.Subject;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddBookPage extends GridPane {
    TextField name = new TextField();
    TextField author = new TextField();
    ChoiceBox<String> types = new ChoiceBox<>();
    String typeStrings[] = {"Novel", "History", "Philosophy"};
    Button add = new Button("Add");
    BookTypeFactory bookTypeFactory;
    RemoveSpace remove = new RemoveSpace();

    public AddBookPage() {
        this.setAlignment(Pos.CENTER);
        this.add(name, 0, 0);
        this.add(author, 0, 1);
        this.add(types, 0, 2);
        this.add(add, 0, 3);
        name.setPromptText("Name of the Book");
        author.setPromptText("Name of the Author");
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        name.getStyleClass().add("AddBookTextBox");
        author.getStyleClass().add("AddBookTextBox");
        types.getStyleClass().add("AddBookChoiceBox");
        add.getStyleClass().add("AddBookButton");
        this.setHgap(5);
        this.setVgap(5);

        types.setItems(FXCollections.observableArrayList(typeStrings));
        add.setOnAction(e -> {
            if(name.getText().isEmpty() || author.getText().isEmpty() || types.getValue().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You fill all the fields");
                alert.show();
            }
            else{
            bookTypeFactory = new BookTypeFactory();
            Book newBook = new Book();
            newBook.setName(String.valueOf((remove.removeSpace(name.getText()))));
            newBook.setAuthor(String.valueOf(remove.removeSpace(author.getText())));
            newBook.setBookTypes(bookTypeFactory.setBookType(types.getValue()));
            FileWriter writer = new FileWriter(newBook);

            Subject subject = new Subject();
            Customer newCustomer = new Customer(subject);
            subject.setNotification(newBook);}
        });

        }


}

