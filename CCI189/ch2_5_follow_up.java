public class ch2_5_follow_up{
    public static void main(String args[]){
        linkedList l1 = new linkedList();
        linkedList l2 = new linkedList();

        for(int i=0;i<args[0].length();i++)
            l1.addNode(Integer.valueOf(args[0].substring(i,i+1)).intValue());

        for(int i=0;i<args[1].length();i++)
            l2.addNode(Integer.valueOf(args[1].substring(i,i+1)).intValue());

        l1.printList();
        l2.printList();

        int num_digits = args[0].length();

        if(args[0].length() < args[1].length()){
            paddingZeros(l1, args[1].length()-args[0].length());
            num_digits = args[1].length();
        }
        else if(args[0].length() > args[1].length())
            paddingZeros(l2, args[0].length()-args[1].length());

        l1.printList();
        l2.printList();

        linkedList result = new linkedList();
        int carry_bit = sum(result, l1.head, l2.head);
        if(carry_bit != 0){
            listNode t = new listNode(carry_bit);
            t.next = result.head;
            result.head = t;
        }

        result.printList();
    }


    private static int sum(linkedList result, listNode n1, listNode n2){
        if(n1.next == null && n2.next == null){
            result.head = new listNode((n1.val+n2.val)%10);
            return (n1.val+n2.val)/10;
        }

        int carry_bit = sum(result, n1.next, n2.next);
        listNode t = new listNode((n1.val+n2.val+carry_bit)%10);
        t.next = result.head;
        result.head = t;

        return (n1.val+n2.val+carry_bit)/10;
    }

    private static void paddingZeros(linkedList l, int n){
        for(int i=0;i<n;i++){
            listNode t = new listNode(0);
            t.next = l.head;
            l.head = t;
        }
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
