import java.util.Random;

public class ch2_4{
    public static void main(String args[]){
        Random rnd = new Random();
        int n = Integer.valueOf(args[0]).intValue();
        int cut_off_value = Integer.valueOf(args[1]).intValue();

        linkedList list = new linkedList();
        for(int i=0;i<n;i++)
            list.addNode(rnd.nextInt(100));

        list.printList();
        listNode result_head = prtitionList(list, cut_off_value);

        listNode current = result_head;
        while(current != null){
            System.out.printf("%d --> ", current.val);
            current = current.next;
        }
        System.out.println("null");
        
    }

    private static listNode prtitionList(linkedList l, int c){
        listNode head = l.head;
        listNode tail = l.head;

        listNode current = l.head.next;
        listNode next;
        while(current != null){
            next = current.next;
            if(current.val < c){
                current.next = head;
                head = current;
            }
            else{
                tail.next = current;
                tail = current;
            }
            current = next;
        }
        tail.next = null;

        return head;   
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
         this.current = this.head;;
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
