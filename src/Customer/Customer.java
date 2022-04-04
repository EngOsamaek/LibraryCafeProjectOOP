package Customer;

import FileOperations.FileWriter;
import Library.Book;
import Library.Observer.NotifiedCustomer;
import Library.Observer.Subject;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Customer extends NotifiedCustomer implements NotificationUpdate {


    private String firstName;
    private String lastName;
    private String number;
    private String userName;
    private String password;
    private String IdentitiyNum ;

    public Customer(String userName, String password, String firstName, String lastName, String number, String identitiyNum){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.IdentitiyNum = identitiyNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentitiyNum() {
        return IdentitiyNum;
    }

    public void setIdentitiyNum(String identitiyNum) {
        IdentitiyNum = identitiyNum;
    }


    public Customer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getNotification());
        new FileWriter(subject.getNotification());
    }

    @Override
    public void notifUpdate() {
        update();
    }
}
