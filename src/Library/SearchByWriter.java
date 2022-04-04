package Library;

import Customer.*;
import FileOperations.FileReader;
import javafx.scene.control.Alert;

import java.util.List;

public class SearchByWriter implements Search{
    List<Filter> arrayList;

    @Override
    public void Search(String details) throws Exception{
        AbstractBook a=BookFactory.getBook(details,"Author");

        if (a.getBookName().equalsIgnoreCase("not available Book")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(a.getBookName());
            alert.show();
        }
        else {
            FileReader fileReader = new FileReader("Book");
            Criteria criteria = new AuthorFilter(details);
            arrayList = criteria.bookFilter(arrayList);
            new CustomerFilterBooks().writeToFile(arrayList);
            new BookTable();
        }

    }
}
