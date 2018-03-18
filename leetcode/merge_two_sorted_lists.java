import java.util.Random;

public class merge_two_sorted_lists{
    public static void main(String args[]){
        int n1 = Integer.valueOf(args[0]).intValue();
        int n2 = Integer.valueOf(args[1]).intValue();

        Random rand = new Random();

        ListNode l1 = new ListNode(rand.nextInt(10*n1));
        ListNode l2 = new ListNode(rand.nextInt(10*n2));

        ListNode currNode = l1;
        for(int i=1;i<n1;i++){
            currNode.next = new ListNode(currNode.val+rand.nextInt(10*n1));
            currNode = currNode.next;
        }

        currNode = l2;
        for(int i=1;i<n2;i++){
            currNode.next = new ListNode(currNode.val+rand.nextInt(10*n2));
            currNode = currNode.next;
        }

        currNode = l1;
        for(int i=0;i<n1;i++){
            System.out.printf("%d -> ", currNode.val);
            currNode = currNode.next;
        }
        System.out.println("");

        currNode = l2;
        for(int i=0;i<n2;i++){
            System.out.printf("%d -> ", currNode.val);
            currNode = currNode.next;
        }
        System.out.println("");


        currNode = l1;
        ListNode prevNode2 = null;
        ListNode currNode2 = l2;
        ListNode head = l2;

        while(currNode != null && currNode2 != null){
  
            if(currNode.val >= currNode2.val){
                prevNode2 = currNode2;
                currNode2 = currNode2.next;
            }
            else{
                if(prevNode2 == null){
                    prevNode2 = currNode;
                    currNode = currNode.next;
                    prevNode2.next = currNode2;
                    head = prevNode2;
                }
                else{
                    prevNode2.next = currNode;
                    currNode = currNode.next;
                    prevNode2.next.next = currNode2;
                    prevNode2 = prevNode2.next;
                }
            }

        }

        if(currNode2 == null)
            prevNode2.next = currNode;
       

        currNode = head;
        for(int i=0;i<n2+n1;i++){
            System.out.printf("%d -> ", currNode.val);
            currNode = currNode.next;
        }
        System.out.println("");
       

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
