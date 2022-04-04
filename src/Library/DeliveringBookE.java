package Library;
import Email.CollectEmail;
import Email.EmailExecutor;
import FileOperations.FileReader;
import FileOperations.FileUpdater;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DeliveringBookE extends GridPane
{
    String name,id,time1,time2;
    boolean bookCheck = false;
    TextField BookID = new TextField();
    TextField UserID = new TextField();
    Label bookID = new Label("Please Enter A valid Book ID");
    Label idNum = new Label("Please Enter A valid Student ID");
    Button deliver = new Button("DELIVER");

    BookTypeFactory bookTypeFactory;

    private DatePicker TimePicker = new DatePicker();
    LocalDate today = LocalDate.now();
    String givenTime;
    public DeliveringBookE()
    {
        BookID.setPromptText("Enter Book ID");
        UserID.setPromptText("Enter User ID");
        //UserIDD.setPromptText("Enter Authors Name");
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        this.setVgap(10);
        BookID.getStyleClass().add("DeliverTextBox");
        UserID.getStyleClass().add("DeliverTextBox");
        deliver.getStyleClass().add("DeliverBookButton");
        TimePicker.getStyleClass().add("DeliverTimePick");

        this.add(BookID, 0, 0);
        this.add(UserID, 0, 1);
        this.add(TimePicker, 0, 2);
        this.add(deliver, 0, 3);
        this.setAlignment(Pos.CENTER);

        new TextFieldConditions(BookID);
        new TextFieldConditions(UserID);
        TimePicker.setEditable(false);
        TimePicker.setPromptText("Return Date");


        deliver.setOnAction((e)->{
            try {
                if (BookID.getText().isEmpty() || UserID.getText().isEmpty() || TimePicker.getValue() == null){
                    Alert alert1=new Alert(Alert.AlertType.ERROR);
                    alert1.setContentText("You should fill all the fields");
                    alert1.show();
                }
                else{
                FileReader fileReader = new FileReader("Book");
                FileReader fileReaderNotification = new FileReader("Notif");
                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                if (!checkIfUser(UserID.getText())){
                    Alert successfully = new Alert(Alert.AlertType.WARNING);
                    successfully.setTitle("Library Management System");
                    successfully.setHeaderText("The User ID is Not Exist");
                    successfully.showAndWait();

                }
                else {

                    for (var books : FileReader.books) {
                        if (books.getID() == Integer.parseInt(BookID.getText()) && books.getAvaliability().equals("Available")) {
                            new FileUpdater(books, fileReader,true);
                            bookTypeFactory = new BookTypeFactory();

                            books.setName(books.getName());
                            books.setAuthor(books.getAuthor());
                            books.setBookTypes(bookTypeFactory.setBookType(books.getBookType()));
                            books.setID(books.getID());
                            givenTime = dateFormat.format(date);
                            books.setGiventime(givenTime);
                            books.setTakentime(TimePicker.getValue().toString());
                            books.setIdNumber(UserID.getText());
                            books.setAvaliability("Unavailable");


                            new FileUpdater(books, fileReader);
                            name=books.getName();
                            id=UserID.getText();
                            time1=books.getGiventime();
                            time2=books.getTakentime();

                            bookCheck = true;
                            break;

                        }

                        bookCheck = false;


                    }
                    if (!bookCheck) {
                        Alert successfully = new Alert(Alert.AlertType.WARNING);
                        successfully.setTitle("Library Management System");
                        successfully.setHeaderText("The Book Couldn't Be Found in the System");
                        successfully.showAndWait();
                    } else {
                        Alert successfully = new Alert(Alert.AlertType.INFORMATION);
                        successfully.setTitle("Library Management System");
                        successfully.setHeaderText("The Book Has Been Successfully Delivered");
                        successfully.showAndWait();

                        new EmailExecutor(name,id,time1,time2,new CollectEmail()).execute();

                    }
                }

            }} catch (Exception exception) {
                exception.printStackTrace();
            }



        });

        }


    boolean checkIfUser(String userID){
        File  file=new File("src//Customer//Customer.txt");
        String user,pass,name,last,number,id,email;
        try {         Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                user=scanner.next();
                pass=scanner.next();
                name=scanner.next();
                last=scanner.next();
                email=scanner.next();
                number=scanner.next();
                id=scanner.next();
                if (userID.compareTo(id)==0){
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;


    }


}
