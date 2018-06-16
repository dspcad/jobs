import java.util.LinkedList;

public class ch4_8{
    public static void main(String args[]){
        treeNode n0 = new treeNode(20);
        treeNode n1 = new treeNode(10);
        treeNode n2 = new treeNode(30);
        treeNode n3 = new treeNode(5);
        treeNode n4 = new treeNode(15);
        treeNode n5 = new treeNode(3);
        treeNode n6 = new treeNode(7);
        treeNode n7 = new treeNode(17);

        n0.left  = n1;
        n0.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n3.left  = n5;
        n3.right = n6;

        n4.right = n7;

        LinkedList<treeNode> queue = new LinkedList<treeNode>();
        queue.add(n0);
        printBFS(queue);


        treeNode result = findCommonAncestor(n0, n7, n4);

        if(result != null)
            System.out.println("The common ancestor: "+result.val);
        else
            System.out.println("No such node.");
        
        
    }

    public static treeNode findCommonAncestor(treeNode root, treeNode p, treeNode q){
        if(root == p)
            return p;

        if(root == q)
            return q;

        if(findNode(root.left, p) && findNode(root.left, q))
            return findCommonAncestor(root.left, p, q);

        if(findNode(root.right, p) && findNode(root.right, q))
            return findCommonAncestor(root.right, p, q);

        if(findNode(root.right, p) && findNode(root.left, q))
            return root;

        if(findNode(root.left, p) && findNode(root.right, q))
            return root;

        return null;
    }


    public static boolean findNode(treeNode root, treeNode target){
        LinkedList<treeNode> Q = new LinkedList<treeNode>();
        Q.add(root);
        while(Q.size() != 0){
            treeNode node = Q.poll();
            if(target == node)
                return true;
            else{
                if(node.left != null)
                    Q.add(node.left);
 
                if(node.right != null)
                    Q.add(node.right);
            }
        }

        return false;
    }

    public static void printBFS(LinkedList<treeNode> Q){
        while(Q.size() != 0){
            treeNode node = Q.poll();
            System.out.println("node value: "+node.val);
            node.visited = true;
            if(node.left != null && node.left.visited == false)
                Q.add(node.left);

            if(node.right != null && node.right.visited == false)
                Q.add(node.right);
        }
    }
}

class treeNode{
    public int val;
    public treeNode left;
    public treeNode right;
    public boolean visited;

    public treeNode(int value){
        this.val = value;
        this.visited = false;
        this.left = null;
        this.right = null;
    }
}
