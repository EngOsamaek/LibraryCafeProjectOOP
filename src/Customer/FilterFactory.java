package Customer;

import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.util.List;

public class FilterFactory implements AbstractFilterFactory {
    Alert aler= new Alert(Alert.AlertType.ERROR);

    List<Filter> arraylist;
    CustomerFilterBooks customerFilterBooks=new CustomerFilterBooks();
    @Override
    public Criteria getCriteria(List<Criteria> criteriaList) {
        if (criteriaList.size()==3){
            if (getAllTypes(criteriaList).bookFilter(arraylist).size()==0){
                aler.setContentText("Not available books");
                aler.show();
                CustomerFilterBooks.tableBox.getChildren().removeAll(CustomerFilterBooks.tableView);
                CustomerFilterBooks.tableView=null;
            }
            else {
                if (CustomerFilterBooks.tableView==null){
                    CustomerFilterBooks.tableView=new TableView<Filter>();
                }
                new CustomerFilterBooks().writeToFile(getAllTypes(criteriaList).bookFilter(arraylist));
                CustomerFilterBooks.tableView = new BookTable().table;
            }}

        else if (criteriaList.size()==2){
            if (getObject(criteriaList).bookFilter(arraylist).size()==0){
                aler.setContentText("Not available books");
                aler.show();

                CustomerFilterBooks.tableBox.getChildren().removeAll(CustomerFilterBooks.tableView);

                CustomerFilterBooks.tableView=null;
            }
            else {
                if (CustomerFilterBooks.tableView==null){
                    CustomerFilterBooks.tableView=new TableView<Filter>();
                    ;}


                new CustomerFilterBooks().writeToFile(getObject(criteriaList).bookFilter(arraylist));
                CustomerFilterBooks.tableView = new BookTable().table;
            }

        }
        else {
            new CustomerFilterBooks().writeToFile(criteriaList.get(0).bookFilter(arraylist));
            CustomerFilterBooks.tableView=new BookTable().table;

        }
        return null;
    }
    AvailableAndType getObject(List<Criteria> criteriaList){
        return new AvailableAndType(criteriaList.get(0),criteriaList.get(1));
    }
    AllTypes getAllTypes(List<Criteria> criteriaList){
        return new AllTypes(criteriaList.get(0),criteriaList.get(1),criteriaList.get(2));
    }
}
