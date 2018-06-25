import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class three_sum{
    public static void main(String args[]){
        int [] nums = {0, 0, 0};
        //int [] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> result = sum(nums);

        for(ArrayList<Integer> elem : result){
            System.out.println(elem);
        }
    }

    public static ArrayList<ArrayList<Integer>> sum(int [] nums){
        HashMap<Integer,HashSet<Integer>> tbl = new HashMap<Integer,HashSet<Integer>>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        HashSet<Integer> indexSet;

        HashSet<String> solSet = new HashSet<String>();

        for(int i=0;i<nums.length;i++){
            if(tbl.containsKey(nums[i])){
                indexSet = tbl.get(nums[i]);
                indexSet.add(i);
            }
            else{
                indexSet = new HashSet<Integer>();
                indexSet.add(i);
                tbl.put(nums[i], indexSet);
            }

        }

        for(Integer elem : tbl.keySet())
            System.out.println("key: "+elem+"  value: "+tbl.get(elem));

        boolean zeros = false;

        for(int i=0;i<nums.length-2;i++){
            int a = nums[i];
            
            if(a > 0)
                break;

            for(int j=i+1;j<nums.length;j++){
                int b = nums[j];

                if(tbl.containsKey(-a-b)){
                    indexSet = tbl.get(-a-b);
                    boolean c_flag = false;
                    for(Integer index : indexSet)
                        if(index > j)
                            c_flag = true;


                    if(c_flag && !checkDuplicate(solSet, a, b, -a-b)){
                        ArrayList<Integer> sol = new ArrayList<Integer>();
                        sol.add(a);
                        sol.add(b);
                        sol.add(-a-b);
                        output.add(sol);
                        
                        if(a==0 && b==0){
                            zeros = true;
                            break;
                        }
                    }
                }
            }

            if(zeros)
                break;
        }

        return output;
    }

    public static boolean checkDuplicate(HashSet<String> solSet, int a, int b, int c){
        StringBuilder str = new StringBuilder(3);
        str.append(a);
        str.append(b);
        str.append(c);

        if(solSet.contains(str.toString()))
            return true;
        else{
            solSet.add(str.toString());
            return false;
        }
    }
}
