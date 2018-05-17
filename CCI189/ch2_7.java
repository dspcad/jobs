

public class ch2_7{
    public static void main(String args[]){

        linkedList l1 = new linkedList();
        linkedList l2 = new linkedList();

        for(int i=0;i<7;i++)
            l1.addNode(i);


        for(int i=0;i<3;i++)
            l2.addNode(i);


        l2.head.next.next = l1.head.next.next.next.next;

        l1.printList();
        l2.printList();

        System.out.println("The length of l1: "+l1.getLength());
        System.out.println("The length of l2: "+l2.getLength());

        int offset;
        listNode l1_offset = l1.head;
        listNode l2_offset = l2.head;
        if(l1.getLength() > l2.getLength()){
            offset = l1.getLength() - l2.getLength();
            for(int i=0;i<offset;i++)
                l1_offset = l1_offset.next;

        }
        else{
            offset = l2.getLength() - l1.getLength();
            for(int i=0;i<offset;i++)
                l2_offset = l2_offset.next;

        }


        while(l1_offset != l2_offset){
            l1_offset = l1_offset.next;
            l2_offset = l2_offset.next;
        }
                
        if(l1_offset == null)
            System.out.println("No intersection.");
        else
            System.out.println("The value of the intersection: "+l1_offset.val);
            
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

    public int getLength(){
        int length = 0;
        listNode cur = this.head;

        while(cur != null){
            length++;
            cur = cur.next;
        }

        return length;
    }
}
