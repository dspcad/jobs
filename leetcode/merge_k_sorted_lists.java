import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class merge_k_sorted_lists{
    public static void main(String args[]){
        int k = Integer.valueOf(args[0]);
        ArrayList<LinkedList<Integer>> sorted_lists = new ArrayList<LinkedList<Integer>>(k);
        Random rnd = new Random();

        //Data preparation
        for(int i=0;i<k;i++)
            sorted_lists.add(new LinkedList<Integer>());

        for(int i=0;i<k;i++){
            int number = rnd.nextInt(10);

            for(int j=0;j<number;j++)
                sorted_lists.get(i).add(rnd.nextInt(100));
        }
            

        for(int i=0;i<k;i++)
            Collections.sort(sorted_lists.get(i));


        for(int i=0;i<k;i++)
            System.out.println(sorted_lists.get(i));

        LinkedList<Integer> result = mergeKLists(sorted_lists);
        System.out.println(result);
        
    }

    public static LinkedList<Integer> mergeKLists(ArrayList<LinkedList<Integer>> lists) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while(!isEmpty(lists)){
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i=0;i<lists.size();i++){
                if(lists.get(i).size() > 0)
                    if(lists.get(i).peek() < min){
                        min = lists.get(i).peek();
                        idx = i;
                    }
            }

            result.add(lists.get(idx).poll());
        }

        return result;
    }

    public static boolean isEmpty(ArrayList<LinkedList<Integer>> lists){
         for(int i=0;i<lists.size();i++){
             if(lists.get(i).size() != 0)
                 return false;
         }

         return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
