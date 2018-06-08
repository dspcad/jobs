
public class ch4_2{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int [] input = new int[n];
        
        for(int i=0; i<n; i++)
            input[i] = i;

        treeNode root = buildBinaryTree(input, 0,n-1);

        printTree(root, 0);
    }


    public static treeNode buildBinaryTree(int [] data, int start, int end){
        if(start <= end){
            treeNode u = new treeNode(data[(end+start)/2]);
            System.out.println(data[(end+start)/2]);

            u.left = buildBinaryTree(data, start, (end+start)/2-1);
            u.right = buildBinaryTree(data, (end+start)/2+1, end);
        
            return u;
        }
        else
            return null;
    }

    public static void printTree(treeNode u, int level){
        System.out.println("level: "+level);
        System.out.println("val: "+u.val);
        System.out.println("============");
 
        if(u.left != null){
            System.out.println("left:");
            printTree(u.left, level+1);
        }

        if(u.right != null){
            System.out.println("right:");
            printTree(u.right, level+1);
        }

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
