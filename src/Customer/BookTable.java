package Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookTable extends StackPane {
    public TableView<Filter> table;

public BookTable(){

    TableColumn<Filter, String> Name = new TableColumn<>("Name");
    Name.setMinWidth(200);
    Name.setCellValueFactory(new PropertyValueFactory<>("name"));
// Name
    TableColumn<Filter, String> author = new TableColumn<>("Author");
    author.setMinWidth(200);
    author.setCellValueFactory(new PropertyValueFactory<>("author"));
// Surname
    TableColumn<Filter, String> type = new TableColumn<>("Type");
    type.setMinWidth(100);
    type.setCellValueFactory(new PropertyValueFactory<>("FilterBookType"));
    //Address
    TableColumn<Filter, String> id = new TableColumn<>("ID");
    id.setMinWidth(100);
    id.setCellValueFactory(new PropertyValueFactory<>("FilterBookID"));

    TableColumn<Filter,String> availability=new TableColumn<Filter, String>("Availability");
    availability.setMinWidth(100);
    availability.setCellValueFactory(new PropertyValueFactory<>("Availability"));

    table = new TableView<>();

    table.getColumns().addAll(Name, author, type, id,availability);

    table.setItems(maketable());}




    public ObservableList<Filter> maketable() throws NullPointerException {
        ObservableList<Filter> books = FXCollections.observableArrayList();





    try {
        Scanner scanner = new Scanner(new File("src/FileOperations/FilterBook.txt"));
        while (scanner.hasNext()) {
            books.addAll(new Filter(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next()));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }




        return books;

    }

}
