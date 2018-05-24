import java.util.Stack;
import java.util.Random;

public class ch3_4{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        Random rnd = new Random();
        myQueue q = new myQueue();
        int val;

        for(int i=0;i<3;i++){
            val = rnd.nextInt(100);
            q.enqueue(val);
        }

        for(int i=0;i<2;i++)
            q.dequeue();

        for(int i=0;i<3;i++){
            val = rnd.nextInt(100);
            q.enqueue(val);
        }

        for(int i=0;i<2;i++)
            q.dequeue();
    }

}

class myQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public myQueue(){
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }

    public void enqueue(int value){
        this.s1.push(value);
        System.out.println("Enqueued value: "+value);
    }

    public int dequeue(){
        if(this.s2.empty()){
            while(!this.s1.empty())
                this.s2.push(this.s1.pop());

        }

        System.out.println("Dequeued value: "+s2.peek());
        return this.s2.pop();
           
    }

    public boolean empty(){
        if(this.s1.empty() && this.s2.empty())
            return true;
        else
            return false;
    }
}
