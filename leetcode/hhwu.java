
import java.util.ArrayList;
import java.lang.StringBuilder;

public class hhwu{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        System.out.println("The number of pairs: "+ n);

        ArrayList<String> result = generateParenthesis(n);
        for(String elem : result)
            System.out.println(elem);

    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public static void backtrack(ArrayList<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}

