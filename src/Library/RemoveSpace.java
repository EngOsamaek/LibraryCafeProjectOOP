package Library;

public class RemoveSpace {
    public StringBuilder removeSpace(String name1){
        StringBuilder name=new StringBuilder(name1);
        for (int i=0;i<name.length();i++){
            if (name.charAt(i)==' '){
                name.setCharAt(i,'-');
            }
        }
        return name;
    }
}
