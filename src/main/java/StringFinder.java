import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringFinder {

    public final List<String> collection;

    public StringFinder(List<String> collection) {
        this.collection = collection;
    }

    private boolean find(String in, String expression){
        int j=0;
        Boolean found = false;
        for(int i=0;i<expression.length(); ++i){
            found = false;
            for(;j<in.length();++j){
                if(expression.charAt(i) == in.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if(!found)
                return false;
        }
        return true;
    }

    public List<String> find(String expression){
        return  collection.stream().filter(a -> find(a, expression)).collect(Collectors.toList());
    }

}
