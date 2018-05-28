import java.util.Stack;
import java.util.Random;

public class ch3_2{
    public static void main(String args[]){
        Random rnd = new Random();
        int n = Integer.valueOf(args[0]).intValue();
        stackMin s = new stackMin();
        int val;

        for(int i=0;i<n;i++){
            val = rnd.nextInt(100);
            System.out.printf("%d ", val);
            s.push(val);
        }
        System.out.println("");

        while(!s.empty()){
            System.out.printf("Element: %d ", s.peek());
            System.out.printf("Min:     %d ", s.min());
            System.out.println("");
            s.pop();
        }


    }
    
}


class stackMin extends Stack<Integer>{
    private Stack<Integer> s_min;

    public stackMin(){
        super();
        this.s_min = new Stack<Integer>();
    }

    public void push(int value){
        super.push(value);
        if(value < this.min())
            s_min.push(value);

    }

    public Integer pop(){
        int value = super.pop();
        if(value == s_min.peek())
            s_min.pop();
        
            
        return value;
    }


    public int min(){
        if(s_min.empty())
            return Integer.MAX_VALUE;
        else
            return s_min.peek();
    }
}
