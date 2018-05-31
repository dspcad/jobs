

public class x_order_tree{
    public static void main(String args[]){
        Node root = new Node(10,2);
        root.children[0] = new Node(5,2);
        root.children[1] = new Node(20,2);

        root.children[0].children[0] = new Node();
        root.children[0].children[1] = new Node();
        root.children[0].children[0].val = 9;
        root.children[0].children[1].val = 18;

        root.children[1].children[0] = new Node();
        root.children[1].children[1] = new Node();
        root.children[1].children[0].val = 3;
        root.children[1].children[1].val = 7;

        System.out.println("In-Order Traversal.");
        inOrderTraversal(root);
        System.out.println("======================");
        System.out.println("Pre-Order Traversal.");
        preOrderTraversal(root);
        System.out.println("======================");
        System.out.println("Post-Order Traversal.");
        postOrderTraversal(root);
        System.out.println("======================");
    }


    public static void inOrderTraversal(Node node){
        if(node.children != null){
            inOrderTraversal(node.children[0]);
        }
        visited(node);
        if(node.children != null){
            inOrderTraversal(node.children[1]);
        }
    }

    public static void visited(Node node){
        System.out.println("Node "+node.val+" is visited.");
    }

    public static void preOrderTraversal(Node node){
        visited(node);
        if(node.children != null){
            preOrderTraversal(node.children[0]);
            preOrderTraversal(node.children[1]);
        }
    }

    public static void postOrderTraversal(Node node){
        if(node.children != null){
            postOrderTraversal(node.children[0]);
            postOrderTraversal(node.children[1]);
        }
        visited(node);
    }

}

class Node{
    public int val;
    public Node [] children;

    public Node(){
        this.val = Integer.MIN_VALUE;
        this.children = null;
    }

    public Node(int value, int n){
        this.val = value;
        //NOTE: the array of the Nodes is not initialized yet.
        this.children = new Node[n];
    }

}


