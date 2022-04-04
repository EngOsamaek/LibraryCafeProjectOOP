package FileOperations;

import Library.Book;
import javafx.scene.control.Alert;

import java.io.File;
import java.util.Scanner;

public class FileWriter {

    public FileWriter(Book newBook){

        Scanner reader;
        File myfile = new File("src//FileOperations//Book.txt");
        try {
            java.io.FileWriter filewriter = new java.io.FileWriter(myfile,true);
            filewriter.write("\n"+newBook.getAllProperties());
            filewriter.close();
            Alert successfully = new Alert(Alert.AlertType.INFORMATION);
            successfully.setTitle("Library Management System");
            successfully.setHeaderText("The Book Has Been Successfully Added");
            successfully.showAndWait();


        }catch(Exception e1) {
        }

    }
    public FileWriter(String notification){
        Scanner reader;
        File myfile = new File("src//FileOperations//Notification.txt");
        try {
            java.io.FileWriter filewriter = new java.io.FileWriter(myfile,true);
            filewriter.write("\n"+notification);
            filewriter.close();

        }catch(Exception e1) {
        }

    }

}
