import java.util.ArrayList;

public class ch4_12{
    public static int count = 0;

    public static void main(String args[]){
        treeNode root = new treeNode(10);
        treeNode n1 = new treeNode(5);
        treeNode n2 = new treeNode(-3);
        treeNode n3 = new treeNode(3);
        treeNode n4 = new treeNode(2);
        treeNode n5 = new treeNode(11);
        treeNode n6 = new treeNode(3);
        treeNode n7 = new treeNode(-2);
        treeNode n8 = new treeNode(1);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.right = n5;

        n3.left  = n6;
        n3.right = n7;

        n4.right = n8;

        ArrayList<treeNode> list = new ArrayList<treeNode>();
        list.add(root);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);
        list.add(n7);
        list.add(n8);

        int target_sum = Integer.valueOf(args[0]).intValue();

        for(treeNode elem : list)
            countPath(elem, target_sum, 0);

        System.out.println("The target sum: "+target_sum);
        System.out.println("The total paths: "+count);
    }

    public static void countPath(treeNode node, int target_sum, int partial_sum){
        if(node == null) return;

        partial_sum += node.val;

        if(partial_sum == target_sum)
            count++;

        countPath(node.left, target_sum, partial_sum);
        countPath(node.right, target_sum, partial_sum);

    }
}

class treeNode{
    public int val;
    public treeNode left;
    public treeNode right;

    public treeNode(int value){
        this.val = value;
        this.left = null;
        this.right = null;
    }
}
