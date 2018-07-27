

public class longestLeafToLeaf{
    public static int max = Integer.MIN_VALUE;
    public static treeNode sink_leaf_node = null;

    public static void main(String args[]){
        treeNode n1  = new treeNode(1);
        treeNode n2  = new treeNode(2);
        treeNode n3  = new treeNode(3);
        treeNode n4  = new treeNode(4);
        treeNode n5  = new treeNode(5);
        treeNode n6  = new treeNode(6);
        treeNode n7  = new treeNode(7);
        treeNode n8  = new treeNode(8);
        treeNode n9  = new treeNode(9);
        treeNode n10 = new treeNode(10);
        treeNode n11 = new treeNode(11);
        treeNode n12 = new treeNode(12);
        treeNode n13 = new treeNode(13);
        treeNode n14 = new treeNode(14);
        treeNode n15 = new treeNode(15);
        treeNode n16 = new treeNode(16);

        n1.left  = n2;
        n1.right = n3;

        n2.left  = n4;
        n2.right = n5;

        n3.right = n6;

        n6.left  = n7;
        n6.right = n8;


        n7.left  = n9;
        n7.right = n10;

        n8.left  = n11;
        n8.right = n12;

        n9.left  = n13;

        n12.left  = n14;
        n12.right = n15;

        n13.left  = n16;

        n2.parent = n1;
        n3.parent = n1;
        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n6;
        n8.parent = n6;
        n9.parent = n7;
        n10.parent = n7;
        n11.parent = n8;
        n12.parent = n8;
        n13.parent = n9;
        n14.parent = n12;
        n15.parent = n12;
        n16.parent = n13;
 
        findLongest(n16,n16,0);
        System.out.println("The longest path: "+max);
        System.out.println("The longest path of the lead node: "+sink_leaf_node.name);

        
        System.out.println("The maximum depth of the tree: "+maxDepth(n1));
    }

    //The depth of a node is the number of edges from the tree's root node to the node.
    public static int maxDepth(treeNode node){
        if(node == null)
            return -1;

        int left_depth = maxDepth(node.left);
        int right_depth = maxDepth(node.right);

        return Math.max(left_depth, right_depth)+1;

    }

    public static void findLongest(treeNode src_node, treeNode node, int length){
        if(!node.visited)
            node.len = length;

        node.visited = true;
        System.out.println("node: "+node.name+" length: "+node.len); 

        if(node.left == null && node.right == null && node != src_node){
            if(length > max){
                max = length;
                sink_leaf_node = node;
            }
            return;
        }


        if(node.left != null && !node.left.visited){
            findLongest(src_node, node.left, length+1);
        }


        if(node.right != null && !node.right.visited){
            findLongest(src_node, node.right, length+1);
        }

        if(node.parent != null){
            findLongest(src_node, node.parent, length+1);
        }

    }
}

class treeNode{
    public int name;
    public treeNode parent;
    public treeNode left;
    public treeNode right;
    public boolean visited;
    public int len;


    public treeNode(int value){
        this.name  = value;
        this.parent = null;
        this.left  = null;
        this.right = null;
        this.visited = false;
        this.len= -1;
    }
}
