package Library;

import Customer.BookTable;
import Customer.CustomerFilterBooks;
import Customer.Filter;
import FileOperations.FileReader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SearchByName extends TableView<Filter> implements Search{
    List<Filter> arrayList=new ArrayList<Filter>();
    public BookTable bookTable;
    @Override
    public void Search(String details) throws Exception {

        AbstractBook a=BookFactory.getBook(details,"Name");
        if (a.getBookName().equalsIgnoreCase("not available Book")){
            FileWriter fileWriter=new FileWriter(new File("src/FileOperations/FilterBook.txt"));
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(a.getBookName());
            alert.show();



        }
        else{
        FileReader fileReader = new FileReader("Book");
        for (var books:fileReader.books) {
            if(books.getName().equalsIgnoreCase(details)){
                arrayList.add(new Filter(books.getName(),books.getAuthor(),books.getBookType(),String.valueOf(books.getID()),books.getAvaliability()));
            }}
        new CustomerFilterBooks().writeToFile(arrayList);




        }
    }
    }

