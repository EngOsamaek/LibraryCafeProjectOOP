package Customer;


import FileOperations.FileReader;

import java.util.ArrayList;
import java.util.List;

public class BookTypeFilter implements Criteria {
    String type;
    public BookTypeFilter(String type){
        this.type=type;

    }
    @Override
    public List<Filter> bookFilter(List<Filter> filter) {
        List<Filter> filterArrayListl=new ArrayList<>();
        if (filter==null){
            filter=new ArrayList<Filter>();
        try {
            new FileReader("Book");
            for (int i = 0; i< FileReader.books.size(); i++){
                if (FileReader.books.get(i).getBookType().equalsIgnoreCase(type)){
                    filter.add(  new Filter(FileReader.books.get(i).getName(),FileReader.books.get(i).getAuthor(),FileReader.books.get(i).getBookType(),String.valueOf(FileReader.books.get(i).getID()),FileReader.books.get(i).getAvaliability()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }
    else {
             for (int i=0;i<filter.size();i++){
            if (filter.get(i).getFilterBookType().equalsIgnoreCase(this.type)){
                filterArrayListl.add(filter.get(i));
            }
        }
        return filterArrayListl;
        }
    }
}
