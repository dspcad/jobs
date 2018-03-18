import java.util.Random;

public class binarySearch_ex{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int target = Integer.valueOf(args[1]).intValue();

        //int [] data = new int[n];
        //Random rand = new Random();
        //

        //for(int i=0;i<n;i++)
        //    data[i] = rand.nextInt(10*n);

        //int [] data = {25, 51, 57, 71, 81, 90, 94, 101, 110, 114, 139, 140, 175, 178, 183, 185, 187, 189, 190, 193};
        int [] data = {25};
        quickSort(data,0,n-1);
        for(int i=0;i<n;i++)
            System.out.printf("%d ", data[i]);
        System.out.println("");
 
        int idx = binarySearch(data,0,n-1,target);

        System.out.println("Index: "+idx);
    }

    private static int binarySearch(int [] data, int start, int end, int val){
        if(start <= end){
            int mid = data[(start+end)/2];

            System.out.println("midpoint: "+(start+end)/2);
            System.out.println("start: "+start);
            System.out.println("end: "+end);
            System.out.println("mid: "+mid);
            if(val == mid)
                return (start+end)/2;
            else if(val < mid)
                return binarySearch(data,start,(start+end)/2-1,val);
            else
                return binarySearch(data,(start+end)/2+1,end,val);
        }

        return -1;
    }

    private static void quickSort(int [] data, int start, int end){
        if(start < end){
            int pivot = data[end];
            int i = start;
            int j = start - 1;

            while(i<end){
                if(data[i]<=pivot){
                    j++;
                    swap(data,i,j);
                }

                i++;
            }
            swap(data,end,j+1);

            quickSort(data,start,j);
            quickSort(data,j+2,end);
        }
    }

    private static void swap(int [] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
