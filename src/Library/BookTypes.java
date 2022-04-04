package Library;

public interface BookTypes {
    public String bookType();

}

class Novel implements BookTypes{

    public String bookType(){

       return "Novel";

    }

}

class History implements BookTypes{


    public String bookType(){

        return "History";

    }

}

class Philosophy implements BookTypes{


    public String bookType(){

        return "Philosophy";

    }

}
