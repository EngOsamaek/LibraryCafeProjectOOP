package Library;

import Email.CollectTakenEmail;
import Email.EmailExecutor;
import FileOperations.FileReader;
import FileOperations.FileUpdater;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class ReTakenPage extends GridPane {
    TextField BookID = new TextField();
    Button deliver = new Button("RETURN");
    boolean found=false;
    int i=0;
    String name,id,time1,time2;

    BookTypeFactory bookTypeFactory=new BookTypeFactory();
    Book book=new Book();
    ReTakenPage() throws Exception {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        BookID.getStyleClass().add("ReTakeText");
        deliver.getStyleClass().add("ReTakeButton");
        this.setVgap(10);
        BookID.setPromptText("Enter Book ID");
        this.add(BookID, 0, 0);
        this.add(deliver, 0, 1);
        this.setAlignment(Pos.CENTER);
        FileReader fileReader=new FileReader("Book");
        new TextFieldConditions(BookID);
        deliver.setOnAction((e->{
            if (BookID.getText().isEmpty()){
                Alert alert1 =new Alert(Alert.AlertType.ERROR);
                alert1.setContentText("You should fill the field");
                alert1.show();
            }
            else {
                found = false;
                book = chcekIf(fileReader, BookID.getText());
                if (book == null) {
                    Alert successfully = new Alert(Alert.AlertType.WARNING);
                    successfully.setTitle("Library Management System");
                    successfully.setHeaderText("The Book is Not In The System");
                    successfully.showAndWait();

                } else {

                    if (book.getAvaliability().equalsIgnoreCase("Unavailable")) {
                        name = book.getName();
                        id = book.getIdNumber();
                        time1 = book.getGiventime();
                        time2 = book.getTakentime();
                        found = true;

                        book.setName(book.getName());
                        book.setAuthor(book.getAuthor());
                        book.setBookTypes(bookTypeFactory.setBookType(book.getBookType()));
                        book.setID(book.getID());
                        book.setGiventime("0");
                        book.setTakentime("0");
                        book.setIdNumber("0");
                        book.setAvaliability("Available");
                        try {
                            new FileUpdater(book, fileReader);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }


                    if (!found) {
                        Alert successfully = new Alert(Alert.AlertType.WARNING);
                        successfully.setTitle("Library Management System");
                        successfully.setHeaderText("The Book is Not Delivered To Anyone");
                        successfully.showAndWait();
                    } else {
                        Alert successfully = new Alert(Alert.AlertType.INFORMATION);
                        successfully.setTitle("Library Management System");
                        successfully.setHeaderText("The Book Has Been Successfully retaken ");
                        successfully.showAndWait();
                        new EmailExecutor(name, id, time1, time2, new CollectTakenEmail()).execute();

                    }
                }

            }}));

    }
    Book chcekIf(FileReader fileReader,String id){
        for(int i = 0; i< FileReader.books.size(); i++){
            if (FileReader.books.get(i).getID()==Integer.parseInt(id)) {return FileReader.books.get(i);
            }
        }
        return null;
    }
}
