package Customer;

import FileOperations.FileReader;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerFilterBooks extends BorderPane {
    ChoiceBox<String> bookType=new ChoiceBox<>();
    public static TableView<Filter>tableView=new TableView<Filter>();
    ChoiceBox<String> authorName = new ChoiceBox<>();
    Button showTable=new Button("Search");
    String[] types ;
    Label bookTypeLabel = new Label("Type");
    Label authorLabel = new Label("Author");
    static VBox tableBox = new VBox();
    GridPane mainPane = new GridPane();
    List<Criteria>arrayList;
    public CustomerFilterBooks(){
        this.types= new String[]{"Novel", "History", "Philosophy"};
        bookType.setItems(FXCollections.observableArrayList(types));
        bookType.setValue("Novel");
        try {
            authorName.setItems(FXCollections.observableArrayList(this.getAuthors()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainPane.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(10,10,10,10));
        mainPane.setVgap(10);
        tableBox.setPadding(new Insets(10,10,10,10));
        mainPane.add(bookTypeLabel,0,0);
        mainPane.add(bookType,1,0);
        mainPane.add(authorLabel,0,1);
        mainPane.add(authorName,1,1);
        mainPane.add(showTable,1,2);

        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        bookType.getStyleClass().add("AddBookChoiceBox");
        authorName.getStyleClass().add("AddBookChoiceBox");
        showTable.getStyleClass().add("SearchBookButton");
        bookTypeLabel.getStyleClass().add("OrderPageLabel");
        authorLabel.getStyleClass().add("OrderPageLabel");
        this.getStyleClass().add("CustomerTopMenuBackground");
        this.setTop(mainPane);
        showTable.setOnAction(e->{
            if (bookType.getValue()==null && authorName.getValue()==null){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You should at least choose one");
                alert.show();
            }
            else if (bookType.getValue()==null && authorName.getValue()!=null){
                tableBox.getChildren().removeAll(tableView);
                this.getChildren().remove(tableBox);

                arrayList=new ArrayList<Criteria>();
                arrayList.add(new AvailableBooks());

                arrayList.add(new AuthorFilter(authorName.getValue()));

            }
            else if ( authorName.getValue()==null && bookType.getValue()!=null){
                tableBox.getChildren().removeAll(tableView);
                this.getChildren().remove(tableBox);

                arrayList=new ArrayList<Criteria>();
                arrayList.add(new AvailableBooks());
                arrayList.add(new BookTypeFilter(bookType.getValue()));

            }
            else
            {
                tableBox.getChildren().removeAll(tableView);
                this.getChildren().remove(tableBox);
                arrayList=new ArrayList<Criteria>();
                arrayList.add(new AvailableBooks());
                arrayList.add(new BookTypeFilter(bookType.getValue()));
                arrayList.add(new AuthorFilter(authorName.getValue()));
            }
            new FilterFactory().getCriteria(arrayList);



            if (tableView!=null){
                tableBox.getChildren().addAll(tableView);

                this.setCenter(tableBox);}

        });
    }
    HashSet<String> getAuthors() throws Exception {
        ArrayList<String> author=new ArrayList<>();
        new FileReader("Book");

        FileReader.books.forEach(e->{
            author.add(e.getAuthor()) ;
        });
        Set<String> uniqueAuthors=new HashSet<String>(author);
        return (HashSet<String>) uniqueAuthors;
    }
    public void writeToFile(List<Filter> arrayList){
        File file=new File("src/FileOperations/FilterBook.txt");
        try {
            java.io.FileWriter fileWriter=new java.io.FileWriter(file);
            arrayList.forEach(e->{
                try {
                    fileWriter.write(e.getName()+" "+e.getAuthor()+" "+e.getFilterBookType()+" "+e.getFilterBookID()+" "+e.getAvailability()+"\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
