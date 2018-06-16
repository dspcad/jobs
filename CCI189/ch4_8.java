import java.util.LinkedList;
import java.util.ArrayList;

public class ch4_8{
    public static void main(String args[]){
        treeNode n0 = new treeNode("n0");
        treeNode n1 = new treeNode("n1");
        treeNode n2 = new treeNode("n2");
        treeNode n3 = new treeNode("n3");
        treeNode n4 = new treeNode("n4");
        treeNode n5 = new treeNode("n5");
        treeNode n6 = new treeNode("n6");
        treeNode n7 = new treeNode("n7");
        treeNode n8 = new treeNode("n8");

        ArrayList<treeNode> nodeList = new ArrayList<treeNode>();
        nodeList.add(n0);
        nodeList.add(n1);
        nodeList.add(n2);
        nodeList.add(n3);
        nodeList.add(n4);
        nodeList.add(n5);
        nodeList.add(n6);
        nodeList.add(n7);
        nodeList.add(n8);

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


        int p = Integer.valueOf(args[0]);
        int q = Integer.valueOf(args[1]);

        for(treeNode node : nodeList)
            node.visited = false;

        treeNode result = findCommonAncestor(n0, nodeList.get(p), nodeList.get(q));

        if(result != null && nodeList.get(p).visited && nodeList.get(q).visited)
            System.out.println("The common ancestor: "+result.name);
        else
            System.out.println("No such node.");
        
        
    }

    public static treeNode findCommonAncestor(treeNode root, treeNode p, treeNode q){
        if(root == null) return null;

        //find p
        if(root == p){
             root.visited = true;
             if(findNode(root, q))
                 q.visited = true;

             return root;
        }

        //find q
        if(root == q){
             root.visited = true;
             if(findNode(root, p))
                 p.visited = true;

             return root;
        }

        treeNode x = findCommonAncestor(root.left, p, q);
        treeNode y = findCommonAncestor(root.right, p, q);


        //p and q in two different subtree with the node root
        if(x != null && y != null)
            return root;


        //if one side is null, it is no harm to pass p or q
        //passing p or q up doesn't destroy the logic
        return x == null ? y : x;
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
            System.out.println("node: "+node.name);
            node.visited = true;
            if(node.left != null && node.left.visited == false)
                Q.add(node.left);

            if(node.right != null && node.right.visited == false)
                Q.add(node.right);
        }
    }
}

class treeNode{
    public String name;
    public treeNode left;
    public treeNode right;
    public boolean visited;

    public treeNode(String str){
        this.name = str;
        this.visited = false;
        this.left = null;
        this.right = null;
    }
}
