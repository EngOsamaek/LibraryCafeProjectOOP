package Library;

public class FacadePatternForSearch {

    private SearchByName searchByName;
    private SearchByWriter searchByWriter;
    private SearchByType searchByType;

    FacadePatternForSearch(){

        searchByName = new SearchByName();
        searchByWriter = new SearchByWriter();
        searchByType = new SearchByType();

    }
    public void NameSearch(String details) throws Exception {

        searchByName.Search(details);

    }

    public void WriterSearch(String details) throws Exception {

        searchByWriter.Search(details);

    }

    public void IdSearch(String details) throws Exception {

        searchByType.Search(details);

    }
}
