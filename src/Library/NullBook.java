package Library;

public class NullBook extends AbstractBook {

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getBookName() {
        return "not available Book";
    }
}
