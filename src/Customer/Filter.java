package Customer;

public class Filter {
    String name;
    String author;
    String FilterBookType,FilterBookID;
    String Availability;
    public Filter(String name, String author, String FilterBookType, String FilterBookID,String Availability){
        this.name = name;
        this.author = author;
        this.FilterBookType=FilterBookType;
        this.FilterBookID=FilterBookID;
        this.Availability=Availability;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFilterBookType(String filterBookType) {
        FilterBookType = filterBookType;
    }

    public void setFilterBookID(String filterBookID) {
        FilterBookID = filterBookID;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getFilterBookType() {
        return FilterBookType;
    }

    public String getFilterBookID() {
        return FilterBookID;
    }
}
