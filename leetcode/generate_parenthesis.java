import java.util.ArrayList;
import java.lang.StringBuilder;

public class generate_parenthesis{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        
        ArrayList<String> list = new ArrayList<String>();
        combination(list, "", 0, 0, n);

        for(String elem : list)
            System.out.println(elem);
    }

    private static void combination(ArrayList<String> list, 
                                    String result,
                                    int left_parenthesis, 
                                    int right_parenthesis, 
                                    int n){
        if(left_parenthesis + right_parenthesis == 2*n){
            list.add(result);
        }
        else{
            if(left_parenthesis < n)
                combination(list, result+"(", left_parenthesis+1, right_parenthesis, n);
            
             
            if(left_parenthesis > right_parenthesis)
                combination(list, result+")", left_parenthesis, right_parenthesis+1, n);
            
        }
    }
}
