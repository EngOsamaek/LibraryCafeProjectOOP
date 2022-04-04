package FileOperations;

import Customer.Balance;
import Library.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    File myfile;
    Scanner reader;
    public static ArrayList<UserRegistration> customers;
    public static ArrayList<Book> books = new ArrayList<Book>();
    public static ArrayList<String> notifications = new ArrayList<String>();
    public static ArrayList<Balance> balances =new ArrayList<>();
    public String balance;
    public String ID;
    public FileReader(String type) throws Exception{

        if(type.compareTo("Book")==0){
            this.BookReader();
        }
        else if (type.equalsIgnoreCase("customer")){
        this.getCustomers();
        }
        else if(type.equalsIgnoreCase("Deposit")){
            this.getAccounts();
        }
        else{
            this.NotificationReader();
        }

    }


    public void NotificationReader() throws FileNotFoundException {
        notifications = new ArrayList<String>();
        myfile = new File("src//FileOperations//Notification.txt");
        reader = new Scanner(myfile);
        while(reader.hasNext()){

            notifications.add(reader.next()+" "+reader.next()+" "+ reader.next());

        }
        reader.close();
    }
    public void BookReader() throws FileNotFoundException {
        books = new ArrayList<Book>();
        myfile = new File("src/FileOperations/Book.txt");
        reader = new Scanner(myfile);
        while(reader.hasNext()){
            books.add(new Book(reader.next(),reader.next(),reader.next(),reader.next(),reader.next(),reader.next(),reader.next(),reader.next()));
        }
        reader.close();
    }

    private void getAccounts() {
        balances = new ArrayList<Balance>();
        try {
            Scanner scanner = new Scanner(new File("src//FileOperations//DepositMoney.txt"));
            while (scanner.hasNext()) {
                balances.add(new Balance(scanner.next(), scanner.next()));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





    public void fileReaderDelete(){
        this.myfile.delete();
    }
    public File getFileName(){
        return this.myfile;
    }
private void getCustomers(){
    try {
        customers=new ArrayList<UserRegistration>();
        Scanner scanner=new Scanner(new File("src/Customer/Customer.txt"));

        while (scanner.hasNext()){
            customers.add(new UserRegistration(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next()));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}


}
