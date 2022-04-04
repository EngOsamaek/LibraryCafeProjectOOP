package FileOperations;

import Customer.Balance;
import Library.Book;

import java.io.File;

public class FileUpdater {
    public FileUpdater(Book book, FileReader fileReader) throws Exception {

        java.io.FileWriter fileWriter=new java.io.FileWriter("src/FileOperations/Book.txt");
        for (var books:fileReader.books){
            if (book.getID()!=books.getID()){
                    fileWriter.write(books.getAllProperties()+"\n");
            }
            else{
                    fileWriter.write(book.getAllProperties()+"\n");
            }

        }

        fileWriter.close();
    }

    public FileUpdater(Book book, FileReader fileReader, boolean control) throws Exception {

        java.io.FileWriter fileWriter=new java.io.FileWriter("src//FileOperations//Notification.txt");
        for (var notifs:fileReader.notifications){
            if (notifs.compareTo(book.getID()+" "+book.getName()+" "+book.getAuthor())==0){
                fileWriter.write(" ");
            }
            else{
                fileWriter.write("\n");
                fileWriter.write(notifs);
            }

        }

        fileWriter.close();
    }
    public FileUpdater(Balance balance){
        try {
            new FileReader("Balance");

            java.io.FileWriter fileWriter=new java.io.FileWriter(new File("src//FileOperations//DepositMoney.txt"));
            for (Balance e:FileReader.balances){
                if (!e.getID().equalsIgnoreCase(balance.getID())){
                    fileWriter.write(e.getID()+" "+e.getBalance()+"\n");
                }

                else{
                    fileWriter.write(balance.getID()+" "+balance.getBalance()+"\n");
                }
            }fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public FileUpdater(String customerID, double Money) throws IOException {
        java.io.FileWriter fileWriter=new java.io.FileWriter("src//FileOperations//DepositMoney.txt");
        for(int i=0; i<FileReader.customers.size(); i++){
            if(FileReader.customers.get(i).getIDNum().compareTo(customerID)==0){
                fileWriter.write(customerID+" "+Money);
            }
            else{

            }
        }
        fileWriter.close();
    }*/

}