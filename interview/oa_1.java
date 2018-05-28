import java.util.HashSet;

public class oa_1{
    public static void main(String args[]){
         String s = args[0];
         int l = Integer.valueOf(args[1]).intValue();
         HashSet<String> set = new HashSet<String>();
         HashSet<String> set_for_substring = new HashSet<String>();

         for(int i=0;i+l<=s.length();i++){
             //if(!set.contains(s.substring(i,i+l)))
             String sub_s = s.substring(i,i+l);
             set_for_substring.clear();
             for(int j=0;j<sub_s.length();j++)
                 set_for_substring.add(sub_s.substring(j,j+1));

             if(set_for_substring.size() == l)
                 set.add(sub_s);
         }
          
         System.out.println(set);
    }

}
