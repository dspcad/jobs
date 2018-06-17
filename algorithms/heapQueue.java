import java.util.Random;
import java.util.ArrayList;

public class heapQueue{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        Random rnd = new Random();
        
        ArrayList<Integer> heap = new ArrayList<Integer>();
        heap.add(Integer.MIN_VALUE);
        for(int i=1;i<=n;i++)
            heap.add(rnd.nextInt(10*n));

 
        for(Integer elem : heap)
            System.out.printf("%d ", elem);
        System.out.println("");


        buildMaxHeap(heap);
        for(Integer elem : heap)
            System.out.printf("%d ", elem);
        System.out.println("");


        insert(heap, 200);
        for(Integer elem : heap)
            System.out.printf("%d ", elem);
        System.out.println("");



    }

    public static void insert(ArrayList<Integer> heap, int value){
        heap.add(value);
        int idx = heap.size()-1;

        while(idx >= 1){
            maxHeaptify(heap, idx);
            idx = idx/2;
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> heap){
        for(int i=(heap.size()-1)/2; i>=1; i--)
            maxHeaptify(heap, i);
    }

    public static void maxHeaptify(ArrayList<Integer> heap, int idx){
        Integer max = heap.get(idx);

        if(2*idx < heap.size() && max < heap.get(2*idx)){
            heap.set(idx, heap.get(2*idx));
            heap.set(2*idx, max);
            max = heap.get(idx);
        }

        if(2*idx+1 < heap.size() && max < heap.get(2*idx+1)){
            heap.set(idx, heap.get(2*idx+1));
            heap.set(2*idx+1, max);
            max = heap.get(idx);
        }

    }
}
