package Library;

public class RealBooks extends AbstractBook {
    RealBooks(String bookName){
    this.bookName=bookName;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String getBookName() {
        return "";
    }
}
