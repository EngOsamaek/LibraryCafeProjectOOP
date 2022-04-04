package Library;

public class TypesOfSearch {

    public TypesOfSearch(String typeOfSearch,String detail){
        FacadePatternForSearch searcher = new FacadePatternForSearch();
        try {

            if(typeOfSearch.equals("Name")){

                searcher.NameSearch(detail);

            }
            else if(typeOfSearch.equals("Writer")){

                searcher.WriterSearch(detail);

            }
            else if(typeOfSearch.equals("Type")){

            searcher.IdSearch(detail);

            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
