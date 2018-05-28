import java.util.HashSet;
import java.util.ArrayList;

public class oa_3{
    public static void main(String args[]){
        String s = args[0];
        int k = Integer.valueOf(args[1]).intValue();

        HashSet<String> set = new HashSet<String>();
        ArrayList<String> result = new ArrayList<String>();

        for(int i=0;i+k<s.length();i++){
            set.clear();
            String sub_s = s.substring(i,i+k);
            boolean k_disntict = true;
            for(int j=0;j<k;j++){
                if(set.contains(sub_s.substring(j,j+1))){
                    k_disntict = false;
                    break;
                }
                else
                    set.add(sub_s.substring(j,j+1));
            }

            if(k_disntict)
                result.add(sub_s);
        }


        for(String elem : result)
            System.out.println(elem);
    }
}
