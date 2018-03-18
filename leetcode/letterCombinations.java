import java.util.HashMap;
import java.util.ArrayList;

public class letterCombinations{
    public static void main(String args[]){
        HashMap<String,String> dict = new HashMap<String,String>();

        dict.put("2", "abc");
        dict.put("3", "def");
        dict.put("4", "ghi");
        dict.put("5", "jkl");
        dict.put("6", "mno");
        dict.put("7", "pqrs");
        dict.put("8", "tuv");
        dict.put("9", "wxyz");

        if(args.length == 0)
            System.out.println("");
        else{
            String str = args[0];
            System.out.println("Input: "+str);
            ArrayList<String> result = recursivePrint(str, dict);

            for(String elem : result)
                System.out.println(elem);
        }
    }

    public static ArrayList<String> recursivePrint(String str, HashMap<String,String> dict){
        String letters = dict.get(str.substring(0,1));
        if(letters == null)
            letters = "";
        ArrayList<String> result = new ArrayList<String>();

        //System.out.println(str.substring(1));
        if(str.length() == 1){
            if(letters.length() != 0)
                for(int i=0;i<letters.length();i++)
                    result.add(letters.substring(i,i+1));
            else
                result.add("");
                
        }
        else{
            if(letters.length() == 0)
                result = recursivePrint(str.substring(1), dict);

            for(int i=0;i<letters.length();i++){
                String prefix = letters.substring(i,i+1);
                ArrayList<String> tmp = recursivePrint(str.substring(1), dict);

                for(String elem : tmp){
                    String item = prefix+elem;
                    result.add(item);
                }
            }
        }


        return result;
        
    }
}
