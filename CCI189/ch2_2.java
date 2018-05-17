import java.util.Random;

public class ch2_2{
    public static void main(String args[]){
        Random rnd = new Random();
        int n = Integer.valueOf(args[0]).intValue();
        int k = Integer.valueOf(args[1]).intValue();
        System.out.println("The number of elements: "+n);
        System.out.println("The value of k: "+k);

        if(k > n)
            System.exit(0);

        linkedList list = new linkedList();
        for(int i=0;i<n;i++)
            list.addNode(rnd.nextInt(1000));
 
        list.printList();

        listNode runner1 = list.head;
        listNode runner2 = list.head;

        for(int i=0;i<k;i++)
            runner1 = runner1.next;

        while(runner1 != null){
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
 
        System.out.println("The kth element: "+runner2.val);

        printKthToLast(list.head, k);

        
    }

    private static int printKthToLast(listNode n, int k){
        if(n == null)
            return 0;

        int index = printKthToLast(n.next,k) + 1;

        if(index == k)
            System.out.println("The kth element: "+n.val);

        return index;
    }

}

class listNode{
    public int val;
    public listNode next;

    public listNode(){
        this.val = 0;
        this.next = null;
    }

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
