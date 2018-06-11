

public class ch4_6{
    public static void main(String args[]){
        treeNode n0 = new treeNode(0);
        treeNode n1 = new treeNode(1);
        treeNode n2 = new treeNode(2);
        treeNode n3 = new treeNode(3);
        treeNode n4 = new treeNode(4);
        treeNode n5 = new treeNode(5);
        treeNode n6 = new treeNode(6);

        n3.left  = n1;
        n3.right = n5;

        n1.parent = n3;
        n1.left   = n0;
        n1.right  = n2;

        n5.parent = n3;
        n5.left   = n4;
        n5.right  = n6;

        n0.parent = n1;
        n2.parent = n1;
        n4.parent = n5;
        n6.parent = n5;

        printTree(n3);
    }

    public static void printTree(treeNode root){
        if(root == null) return;

        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    public static treeNode sucessor(treeNode u){
        if(u == null) return null;

        if(u.right != null) 
            return findMin(u.right);
        else{
            treeNode q = u;
            treeNode v = u.parent;
            while(v != null && q != v.left){
                q = v;
                v = v.parent;
            }

            return v;
        }

    }

    public static treeNode findMin(treeNode v){
        while(v.left != null)
            v = v.left;
        
        return v;
    }
}

class treeNode{
    public int val;
    public treeNode parent;
    public treeNode left;
    public treeNode right;

    public treeNode(int value){
        this.val = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
