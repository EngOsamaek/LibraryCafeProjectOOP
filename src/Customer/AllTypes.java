package Customer;

import java.util.List;

public class AllTypes implements Criteria {
    Criteria type;
    Criteria author;
    Criteria available;
    AllTypes(Criteria available,Criteria type,Criteria author ){
this.available=available;
this.type=type;
this.author=author;
    }
    @Override
    public List<Filter> bookFilter(List<Filter> book) {
        this.available.bookFilter(book);
        return type.bookFilter(author.bookFilter(book));

    }


}

