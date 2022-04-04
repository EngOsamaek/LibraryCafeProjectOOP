package Customer;

import FileOperations.FileReader;

import java.util.ArrayList;
import java.util.List;

public class AuthorFilter implements Criteria {
    String authors;
    public AuthorFilter(String authors){
        this.authors=authors;
    }
    @Override
    public List<Filter> bookFilter(List<Filter> book) {
        List<Filter> author=new ArrayList<Filter>() ;
if (book==null){
    book=new ArrayList<Filter>();
        try {
            FileReader fileReader=new FileReader("Book");
            for (int i = 0; i< FileReader.books.size(); i++){
                if (FileReader.books.get(i).getAuthor().compareTo(this.authors)==0){
                    book.add(  new Filter(FileReader.books.get(i).getName(),FileReader.books.get(i).getAuthor(),FileReader.books.get(i).getBookType(),String.valueOf(FileReader.books.get(i).getID()),FileReader.books.get(i).getAvaliability()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;}
else {
    for (int i=0;i<book.size();i++){
        if (book.get(i).getAuthor().equalsIgnoreCase(this.authors)){
            author.add(book.get(i));
        }
    }
    return author;
}
    }
}
