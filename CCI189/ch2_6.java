

public class ch2_6{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        linkedList l = new linkedList();

        if(n%2==0){
            for(int i=0;i<n/2;i++)
                l.addNode(i);

            for(int i=n/2-1;i>=0;i--){
                if(i == 1)
                    l.addNode(1111);
                else
                    l.addNode(i);
             }
 
            n = n -2;
        }
        else{
            for(int i=0;i<(n+1)/2;i++)
                l.addNode(i);

            for(int i=(n-3)/2;i>=0;i--)
                l.addNode(i);

        }

        l.printList();
        isPalindrome(l.head,n);
        System.out.println("This is palindrome.");
        
    }

 
    public static listNode isPalindrome(listNode node, int length){
        if(length == 1){
            return node.next;
        }
        else if(length == 0){
            if(node.val != node.next.val){
                System.out.println("This is not palindrome.");
                System.exit(0);
                return null;

            }
            else
                return node.next.next;
        }
        else{
            listNode backNode = isPalindrome(node.next, length - 2);

            System.out.println("node: "+node.val);
            System.out.println("backnode: "+backNode.val);
            if(node.val != backNode.val){
                System.out.println("This is not palindrome.");
                System.exit(0);
                return null;
            }
            else
                return backNode.next;
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
        this.head = current;
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
