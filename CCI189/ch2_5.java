
public class ch2_5{
   public static void main(String args[]){
       linkedList num1 = new linkedList(); 
       linkedList num2 = new linkedList(); 

       for(int i=args[0].length()-1;i>=0;i--)
           num1.addNode(Integer.valueOf(args[0].substring(i,i+1)).intValue());

       num1.printList();

       for(int i=args[1].length()-1;i>=0;i--)
           num2.addNode(Integer.valueOf(args[1].substring(i,i+1)).intValue());

       num2.printList();

       linkedList a = num1.sum(num2);
       a.printList();
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
    listNode head;
    listNode current;

    public linkedList(){
        this.head = null;
        this.current= null;
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
        listNode current = this.head;
        while(current != null){
            System.out.printf("%d --> ", current.val);
            current = current.next;
        }
        System.out.println("null");
    }

    public linkedList sum(linkedList l){
        listNode cur_1 = this.head;
        listNode cur_2 = l.head;

        int s = (cur_1.val+cur_2.val)%10;
        int carry_bit = (cur_1.val+cur_2.val)/10;
        linkedList result = new linkedList(s);
        cur_1 = cur_1.next;
        cur_2 = cur_2.next;

        while(cur_1 != null || cur_2 != null){
            if(cur_1 != null && cur_2 != null){
                s = (cur_1.val+cur_2.val+carry_bit)%10;
                carry_bit = (cur_1.val+cur_2.val+carry_bit)/10;
            }
            else if(cur_1 != null){
                s = (cur_1.val+carry_bit)%10;
                carry_bit = (cur_1.val+carry_bit)/10;
            }
            else{
                s = (cur_2.val+carry_bit)%10;
                carry_bit = (cur_2.val+carry_bit)/10;
            }
            result.addNode(s);
 
            if(cur_1 != null)      
                cur_1 = cur_1.next;

            if(cur_2 != null)
                cur_2 = cur_2.next;
        }

        return result;
    }
}
