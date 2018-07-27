

public class ch4_4{
    public static void main(String args[]){
        treeNode imbalance = new treeNode(0);
        imbalance.left = new treeNode(1);
        imbalance.left.right = new treeNode(1);
        imbalance.left.right.left = new treeNode(2);
        imbalance.left.right.right = new treeNode(3);
        imbalance.right = new treeNode(4);
        imbalance.right.left = new treeNode(5);
        imbalance.right.right = new treeNode(6);
        imbalance.right.right.left = new treeNode(7);
        imbalance.right.right.right = new treeNode(8);
        imbalance.right.right.left = new treeNode(9);

        if(isBalance(imbalance))
            System.out.println("balanced.");
        else
            System.out.println("Not balanced.");

        treeNode balance = new treeNode(0);
        if(checkBalance(balance) != Integer.MIN_VALUE)
            System.out.println("balanced.");
        else
            System.out.println("Not balanced.");



    }

    public static int checkBalance(treeNode u){
        if(u == null)
            return -1;

        int leftHeight = checkBalance(u.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = checkBalance(u.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(Math.abs(leftHeight-rightHeight)>1)
            return Integer.MIN_VALUE;
        else
            return Math.max(leftHeight,rightHeight)+1;
    }

    public static int getHeight(treeNode u){
        if(u == null)
            return -1;

        return Math.max(getHeight(u.left), getHeight(u.right))+1;
    }

    public static boolean isBalance(treeNode root){
        if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1)
            return false;
        else
            return (isBalance(root.left) && isBalance(root.right));
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
