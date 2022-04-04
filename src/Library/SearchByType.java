package Library;

import Customer.*;
import FileOperations.FileReader;
import javafx.scene.control.Alert;

import java.util.List;

public class SearchByType implements Search{
List<Filter> arrayList;
    @Override
    public void Search(String details) throws Exception{
        AbstractBook a=BookFactory.getBook(details,"Type");
        if (a.getBookName().equalsIgnoreCase("not available Book")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(a.getBookName());
            alert.show();



        }
        else {

            FileReader fileReader = new FileReader("Book");
            Criteria criteria = new BookTypeFilter(details);

            new CustomerFilterBooks().writeToFile(criteria.bookFilter(arrayList));
            new BookTable();



    }}
}
