import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class oa_5{
    public static void main(String args[]){
        String excluded_s = new String("a an is the");
        String s = new String("Jimmy has an apple, it is on the table of Jimmy");
  
        HashSet<String> set = new HashSet<String>();
        HashMap<String,Integer> hash_tbl = new HashMap<String,Integer>();

        String [] list = excluded_s.split(" ");
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
            set.add(list[i]);
        }

        String [] words = s.split(" ");
        for(int i=0;i<words.length;i++){
            if(!set.contains(words[i])){
                if(hash_tbl.containsKey(words[i])){
                    int number = hash_tbl.get(words[i]);
                    hash_tbl.put(words[i], number+1);
                }
                else
                    hash_tbl.put(words[i], 1);
            }
        }

        TreeMap<Integer,HashSet<String>> sorted = new TreeMap<Integer,HashSet<String>>();
        int max = 0;
        for(String elem : hash_tbl.keySet()){
            System.out.println("Key: "+elem+"  value: "+hash_tbl.get(elem));

            HashSet<String> tmp;
            if(sorted.containsKey(hash_tbl.get(elem))){
                tmp = sorted.get(hash_tbl.get(elem));
            }
            else{
                tmp = new HashSet<String>();
            }
            tmp.add(elem);
            sorted.put(hash_tbl.get(elem), tmp);
        }

        for(Integer elem : sorted.keySet())
            System.out.println("Key: "+elem+"  value: "+sorted.get(elem));
    }
}
