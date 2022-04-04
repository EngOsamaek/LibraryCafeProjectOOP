package FileOperations;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserRegistration {
    String firstName;
    String lastName;
    String username;
    String password;
    String number;
    String email;
    String IDNum;
    File file=new File("src/Customer/Customer.txt");
    File MoneyFile = new File("src//FileOperations//DepositMoney.txt");

    public String getEmail() {
        return email;
    }

    boolean email1=false;

    Alert alert=new Alert(Alert.AlertType.ERROR);
    UserRegistration(){

    }

    UserRegistration(String username,String password,String firstName,String lastName,String email,String number,String id){
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.email =email;
        this.IDNum=id;
        this.number=number;
    }
    public String checkEmployeeInfo(UserRegistration user) throws Exception {

        if (user.firstName.isEmpty() || user.lastName.isEmpty() || email.isEmpty()||user.number.isEmpty() || user.username.isEmpty() || user.password.isEmpty() || user.IDNum.isEmpty()){
            return "please fill all the fields";
        }
        if (user.number.length()<10){
            return "The number phone should contain 10 digits";
        }
        for (int i=0;i<user.email.length();i++){
            if (user.email.charAt(i)=='@'){
                this.email1=true;}
            if (i==user.email.length() && !this.email1){
                return "You should Enter a real Email";
            }
        }

        if (user.password.length()<8 || user.password.length()>16){
            return "The password should include at least 8 digits and not more than 16";
        }

        new FileReader("customer");
        for (UserRegistration e : FileReader.customers) {
            if (user.username.compareTo(e.getUsername()) == 0) {
                return "This username is already been taken";
            }

            if (user.email.compareTo(e.getEmail()) == 0) {
                return "This Email is Already been take";
            }
            if (user.number.compareTo(e.getNumber()) == 0) {
                return "This Phone Number been taken";
            }
            if (user.IDNum.equals(e.getIDNum())) {
                return "This ID been taken";
            }
        }



        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }

    public String getIDNum() {
        return IDNum;
    }

    void addToFile(UserRegistration user){
        try {
            FileWriter writer=new FileWriter(file,true);
            writer.write(user.username+" "+user.password+" "+user.firstName+" "+user.lastName+" "+user.email+" "+user.number +" "+user.IDNum+"\n");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void MoneyRecordPage(){
        try {
            FileWriter writer=new FileWriter(MoneyFile,true);
            writer.write("\n");
            writer.write(IDNum+" "+"0");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


