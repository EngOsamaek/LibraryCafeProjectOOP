package Library;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Book {
    BookTypes bookTypes;

    private String name;
    private String author;
    private int bookID;
    int bookIDText;
    File myfile;
    Scanner reader;


    public String getGiventime() {
        return giventime;
    }

    public void setGiventime(String giventime) {
        this.giventime = giventime;
    }

    public String getTakentime() {
        return takentime;
    }

    public void setTakentime(String takentime) {
        this.takentime = takentime;
    }

    public String getAvaliability() {
        return avaliability;
    }

    public void setAvaliability(String avaliability) {
        this.avaliability = avaliability;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    String giventime,takentime,avaliability,idNumber;
    BookTypeFactory bookTypeFactory;
    public Book() {
        bookID = randomID();
        IDCompare(bookID);
        giventime = "0";
        takentime = "0";
        avaliability = "Available";
        idNumber = "0";
    }
    public Book(String newName, String newAuthor, String newBookType, String newBookID, String GivenTime, String TakenTime, String IDNum, String Avaliab ){
        bookTypeFactory = new BookTypeFactory();
        this.name = newName;
        this.author = newAuthor;
        this.setBookTypes(bookTypeFactory.setBookType(newBookType));
        this.bookID = Integer.parseInt(newBookID);
        this.giventime = GivenTime;
        this.takentime = TakenTime;
        this.idNumber = IDNum;
        this.avaliability = Avaliab;

    }



    public int getID(){

        return this.bookID;
    }
    public void setID(int newID){
        this.bookID = newID;
    }
    public String getName(){

        return this.name;
    }
    public void setName(String newName){

        this.name = newName;

    }
    public String getAuthor(){

        return this.author;

    }
    public void setAuthor(String newAuthor){

        this.author = newAuthor;

    }
    public String getBookType(){


        return bookTypes.bookType();

    }
    public void setBookTypes(BookTypes newBookType){

        bookTypes = newBookType;

    }

    public int randomID() {

        Random r = new Random();
        return r.nextInt((99999-10000)+1)+10000;
    }
    public String getAllProperties(){

        return this.name+" "+this.author+" "+this.getBookType()+" "+bookID+" "+giventime+" "+takentime+" "+idNumber+" "+avaliability;
    }

    public void IDCompare(int ComparedID){
        System.out.println("Inside");
        try {
            myfile = new File("src/sample/Book.txt");
            reader = new Scanner(myfile);


            while(reader.hasNext()) {
                if(reader.next().equals(ComparedID)){
                    this.bookID = randomID();
                }
                else{
                    System.out.println("Added correctly");
                    break;
                }

            }

            reader.close();
            //	Optional<ButtonType> result = alert.showAndWait();

        }catch(Exception e) {
            System.out.println("A");
        }
    }

}
