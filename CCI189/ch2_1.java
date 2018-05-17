import java.util.Random;
import java.util.HashSet;

public class ch2_1{
    public static void main(String args[]){
        Random rnd = new Random();

        linkedList list = new linkedList(rnd.nextInt(5));
        for(int i=0;i<9;i++)
            list.addNode(rnd.nextInt(5));

        listNode current = list.head;
        while(current != null){
            System.out.printf("%d --> ", current.val);
            current = current.next;
        }
        System.out.println("null");

        removeDup(list);

        current = list.head;
        while(current != null){
            System.out.printf("%d --> ", current.val);
            current = current.next;
        }
        System.out.println("null");


    }

    private static void removeDup(linkedList list){
        HashSet<Integer> table = new HashSet<Integer>();
        listNode previous = list.head;
        listNode current = list.head.next;
        table.add(previous.val);

        while(current != null){
            if(table.contains(current.val)){
                previous.next = current.next;
                current = current.next;
            }
            else{
                table.add(current.val);
                previous = current;
                current = current.next;
            }
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
