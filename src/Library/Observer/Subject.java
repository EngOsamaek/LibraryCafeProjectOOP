package Library.Observer;

import Customer.Customer;
import FileOperations.FileReader;
import Library.Book;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Customer> notifiedCustomers = new ArrayList<Customer>();
    private Book BookNotification;

    public String getNotification(){
        return this.BookNotification.getID()+" "+this.BookNotification.getName()+" "+this.BookNotification.getAuthor();
    }
    public void setNotification(Book newBook){

        this.BookNotification = newBook;
        notifyAllCustomers();

    }

    public void attach(Customer customer){
        notifiedCustomers.add(customer);
    }
    public void notifyAllCustomers(){
        for(Customer customers : notifiedCustomers){
            customers.update();
        }
    }


}
