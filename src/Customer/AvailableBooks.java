package Customer;

import FileOperations.FileReader;

import java.util.ArrayList;
import java.util.List;

public class AvailableBooks implements Criteria {
    Filter filter;
    @Override

    public List<Filter> bookFilter(List<Filter> filter) {
        filter=new ArrayList<Filter>();
        try {
            FileReader fileReader=new FileReader("Book");
            for (int i = 0; i< FileReader.books.size(); i++){
                if (FileReader.books.get(i).getAvaliability().equalsIgnoreCase("Available")){
                    filter.add(  new Filter(FileReader.books.get(i).getName(),FileReader.books.get(i).getAuthor(),FileReader.books.get(i).getBookType(),String.valueOf(FileReader.books.get(i).getID()),FileReader.books.get(i).getAvaliability()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }

}
