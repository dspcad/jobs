import java.util.Random;

public class linkedList_ex{
    public static void main(String args[]){
        Random rnd = new Random();

        linkedList list = new linkedList(rnd.nextInt(5));
        for(int i=0;i<9;i++)
            list.addNode(rnd.nextInt(5));

        listNode current = list.head;
        int i = 1;
        while(current != null){
            System.out.println(i+"th val: "+current.val);
            current = current.next;
            i++;
        }
    }
}

class linkedList{
    public listNode head;
    public listNode current;

    public linkedList(){
        this.head = new listNode();
    }

    public linkedList(int value){
        this.head = new listNode(value);
        this.current = head;
    }

    public void addNode(int value){
        this.current.next = new listNode(value);
        this.current = this.current.next;
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
