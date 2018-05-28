import java.util.Random;
import java.util.Stack;

public class ch3_5{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        Random rnd = new Random();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        int val;
        int duplicate = 0;
        int count = n;

        for(int i=0;i<n;i++){
            val = rnd.nextInt(100);
            s1.push(val);
            System.out.println("The stack value: "+val);
        }


        
        while(!s1.empty()){
            count -= duplicate;
            max = Integer.MIN_VALUE;
            while(!s1.empty()){
                val = s1.pop();
                if(val > max)
                    max = val;

                s2.push(val);
            }


            //System.out.println("The count: "+count);
            duplicate = 0;
            for(int i=0;i<count;i++){
                if(s2.peek() == max){
                    duplicate++;
                    s2.pop();
                }
                else{
                    s1.push(s2.pop());
                }
            }

            for(int i=0;i<duplicate;i++)
                s2.push(max);
        }
        
        while(!s2.empty())
            System.out.println("The sorted stack value: "+s2.pop());
    }
}
