import java.util.Random;
import java.lang.Math;

public class heapSort{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int length = Integer.valueOf(args[1]).intValue();

        Random rn = new Random();
        int [] data = new int[n];

        for(int i=1;i<=length;i++)
            data[i] = rn.nextInt(10*n);

        for(int i=1;i<=length;i++)
            System.out.printf(" %d", data[i]);
        System.out.println("");
        System.out.println("");


        printHeap(data, length);


        for(int i=1;i<=length;i++)
            System.out.printf(" %d", data[i]);
        System.out.println("");
        System.out.println("");
        System.out.println("After building MaxHeap:");

        buildMaxHeap(data, length);
        for(int i=1;i<=length;i++)
            System.out.printf(" %d", data[i]);
        System.out.println("");


    }

    private static void printHeap(int [] data, int length){
        int level = 0;
        int count = 1;
        while(count <= length){
            for(int i=count;i<Math.min(length+1, count+Math.pow(2,level));i++){
                for(int j=0;j<5-level;j++)            
                    System.out.printf(" ");

                System.out.printf("%d", data[i]);
            }

            System.out.println("");
            count += Math.pow(2,level);
            level++;
        }

        System.out.println("");
        System.out.println("");

    }

    private static void buildMaxHeap(int [] data, int length){
        for(int i=length/2;i>=1;i--)
            maxHeaptify(data, i, length);
    }

    private static void maxHeaptify(int [] data, int index, int length){
        int max_index = index;
        int tmp;
        if(index>0){
            if(2*index <= length && data[max_index] < data[2*index])
                max_index = 2*index;
            

            if(2*index+1 <= length && data[max_index] < data[2*index+1])
                max_index = 2*index+1;

            if(max_index != index){
                tmp = data[index];
                data[index] = data[max_index];
                data[max_index] = tmp;
                maxHeaptify(data, max_index, length);
            }

        }
    }
}
