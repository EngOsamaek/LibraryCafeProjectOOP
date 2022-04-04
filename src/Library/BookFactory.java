package Library;

import FileOperations.FileReader;
public class BookFactory {


    static boolean check=true;



    public static AbstractBook getBook(String name, String typeOfSearch) throws Exception {
       BookFactory bookFactory=new BookFactory();
        new FileReader("Book");
        if (typeOfSearch.equalsIgnoreCase("Type")){
            if (bookFactory.searchType(name)){
                return new RealBooks(name);
            }}
            else if(typeOfSearch.equalsIgnoreCase("Author")){
                if(bookFactory.searchAuthor(name)){
                    return new RealBooks(name);
                }
            }
            else if(typeOfSearch.equalsIgnoreCase("Name")){
                if (bookFactory.searchName(name)){
                    return new RealBooks(name);
                }
            }




        return new NullBook();
    }

    boolean searchName(String name) {
        for (int i = 0; i < FileReader.books.size(); i++) {
            if (name.equalsIgnoreCase(FileReader.books.get(i).getName())) {
check=true;
           return true;
            }

        }
        check=false;
        return false;
    }

    boolean searchType(String name){
        for (int i = 0; i < FileReader.books.size(); i++) {
            if (name.equalsIgnoreCase(FileReader.books.get(i).getBookType())) {
                check=true;

                return true;
            }

        }
        check=false;
        return false;
    }
    boolean searchAuthor(String name){
        for (int i = 0; i < FileReader.books.size(); i++) {
            if (name.equalsIgnoreCase(FileReader.books.get(i).getAuthor())) {
                check=true;

                return true;
            }

        }
        check=false;
        return false;
    }
    }


