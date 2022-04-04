package Customer;


import java.util.List;

public class AvailableAndType implements Criteria {
    Criteria available;
    Criteria other;
    AvailableAndType(Criteria criteria,Criteria other){
this.available =criteria;
this.other=other;
    }
    @Override
    public List<Filter> bookFilter(List<Filter> book) {
        book=this.available.bookFilter(book);
        return other.bookFilter(book);
    }
}
