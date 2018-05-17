

public class ch2_8{
    public static void main(String args[]){
        int k         = Integer.valueOf(args[0]).intValue();
        int loop_size = Integer.valueOf(args[1]).intValue();

        linkedList l = new linkedList();
        for(int i=0;i<k+loop_size;i++)
            l.addNode(i);

        l.printList();

        listNode cur = l.head;
        for(int i=0;i<k;i++)
            cur = cur.next;

        l.current.next = cur;

        cur = l.head;
        for(int i=0;i<k+loop_size+3;i++){
            System.out.printf("%d --> ", cur.val);
            cur = cur.next;
        }
        System.out.println("");

        listNode slow_runner_1 = l.head;
        listNode slow_runner_2 = l.head;
        listNode fast_runner   = l.head;

        do{
            slow_runner_1 = slow_runner_1.next;
            fast_runner   = fast_runner.next.next;
        }while(slow_runner_1 != fast_runner);

        System.out.printf("The slow runner 1: %d\n", slow_runner_1.val);
        while(fast_runner != slow_runner_2){
            slow_runner_2 = slow_runner_2.next;
            fast_runner   = fast_runner.next;
        }

        
        System.out.printf("The begining of the loop: %d\n", fast_runner.val);
    }

}

class listNode{
    public int val;
    public listNode next;

    public listNode(int value){
        this.val = value;
        this.next = null;
    }
}

class linkedList{
    public listNode head;
    public listNode current;

    public linkedList(){
        this.head = null;
        this.current = null;
    }

    public linkedList(int value){
        this.head = new listNode(value);
        this.current = this.head;       
    }

    public void addNode(int value){
        if(this.head == null){
            this.head = new listNode(value);
            this.current = this.head;
        }
        else{
            this.current.next = new listNode(value);
            this.current = this.current.next;
        }
    }

    public void printList(){
        listNode cur = this.head;

        while(cur != null){
            System.out.printf("%d --> ", cur.val);
            cur = cur.next;
        }
        System.out.println("null");
    }
}
