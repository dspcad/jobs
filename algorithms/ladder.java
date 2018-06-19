import java.util.ArrayList;

public class ladder{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();

        ArrayList<String> result = backTrace(n);

        for(String elem : result)
            System.out.println(elem);
    }

    public static ArrayList<String> backTrace(int number_ladders){
        ArrayList<String> list = new ArrayList<String>();

        if(number_ladders==0){
            list.add("");
            return list;
        }

        if(number_ladders==1){
            list.add("1");
            return list;
        }

        ArrayList<String> result_1 = backTrace(number_ladders-1);
        ArrayList<String> result_2 = backTrace(number_ladders-2);

        for(String elem: result_1)
            list.add("1"+elem);
        
        for(String elem: result_2)
            list.add("2"+elem);

      
        return list;
    }
}
