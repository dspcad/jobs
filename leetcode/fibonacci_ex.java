import java.util.HashSet;

public class fibonacci_ex{
    public static void main(String args[]){
        int [] A = {2,4,7,8,9,10,14,15,18,23,32,50};

        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int elem : A)
            set.add(elem);
        
        int max_length = 0;
        int xn_2;
        int xn_1;
        
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<A.length;j++){
                xn_2 = A[i];
                xn_1 = A[j];
                
                int len = fibonacci_like(xn_2,xn_1,set);
                if(max_length < len)
                    max_length = len;
            }
        }
        
        System.out.printf("Max len: %d\n", max_length);
    }

    public static int fibonacci_like(int xn_2, int xn_1, HashSet<Integer>set){
        int len = 2;
        int xn = xn_1 + xn_2;
  
        System.out.println("=======================");       
        while(set.contains(xn)){
            len++;
            System.out.printf("xn-2: %d   xn-1: %d)\n", xn_2, xn_1);
            System.out.printf("xn: %d(len: %d)\n", xn, len);
            xn_2 = xn_1;
            xn_1 = xn;
            xn = xn_1 + xn_2;
        }
        
        return len;
    }
}
