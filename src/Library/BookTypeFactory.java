package Library;

public class BookTypeFactory {

    public BookTypes setBookType(String typeValue){

        BookTypes bookType;
        if(typeValue.equals("Novel")){

            return new Novel();

        }
        else if(typeValue.equals("History")){

            return new History();
        }
        else if(typeValue.equals("Philosophy")){

            return new Philosophy();
        }
        else{
            return null;
        }

    }

}
