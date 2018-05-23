import java.util.Stack;
import java.util.Random;

public class ch3_2{
    public static void main(String args[]){
        Random rnd = new Random();
        int n = Integer.valueOf(args[0]).intValue();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s_min = new Stack<Integer>();
        int val;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            val = rnd.nextInt(100);
            System.out.printf("%d ", val);
            s1.push(val);
            if(val < min){
                min = val;
                s_min.push(min);
            }
        }
        System.out.println("");

        while(!s1.empty()){
            if(s1.peek() == s_min.peek()){
                System.out.printf("Element: %d ", s1.pop());
                System.out.printf("Min:     %d ", s_min.pop());
            }
            else{
                System.out.printf("Element: %d ", s1.pop());
                System.out.printf("Min:     %d ", s_min.peek());
            }

            System.out.println("");
        }

    }
    
}

