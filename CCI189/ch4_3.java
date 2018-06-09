import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;

public class ch4_3{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        Random rnd = new Random();
        ArrayList<Integer> data = new ArrayList<Integer>();

        for(int i=0;i<n;i++)
            data.add(rnd.nextInt(10*n));

        System.out.println(data);
        Collections.sort(data);
        System.out.println(data);

        treeNode t = buildBinaryTree(data,0,n-1);

        inOrderPrint(t);

        ArrayList<LinkedList<treeNode>> result_dfs = new ArrayList<LinkedList<treeNode>>();
        dfs(t, result_dfs, 0);
        for(int i=0;i<result_dfs.size();i++){
            LinkedList<treeNode> l = result_dfs.get(i);
            
            System.out.println("level "+i);
            for(treeNode v : l)
                System.out.printf("%d ", v.val);
            System.out.println("");
        }

        System.out.println("------------- BFS ---------------");
        ArrayList<LinkedList<treeNode>> result_bfs = new ArrayList<LinkedList<treeNode>>();
        bfs(t, result_bfs);
        for(int i=0;i<result_bfs.size();i++){
            LinkedList<treeNode> l = result_bfs.get(i);
            
            System.out.println("level "+i);
            for(treeNode v : l)
                System.out.printf("%d ", v.val);
            System.out.println("");
        }

    }

    public static void bfs(treeNode u, ArrayList<LinkedList<treeNode>> result){
        if(u != null){
            LinkedList<treeNode> parent = new LinkedList<treeNode>();
            parent.add(u);
            result.add(parent);

            while(parent.size()>0){
                LinkedList<treeNode> current = new LinkedList<treeNode>();
                for(treeNode v : parent){
                    if(v.left != null)
                        current.add(v.left);

                    if(v.right != null)
                        current.add(v.right);
                }
                result.add(current);
                parent = current;
            }
        }
    }

    public static void dfs(treeNode u, ArrayList<LinkedList<treeNode>> result, int level){
        if(u != null){
            if(result.size() == level){
                LinkedList<treeNode> l = new LinkedList<treeNode>();
                l.add(u);
                result.add(l);

            }
            else{
                LinkedList<treeNode> l = result.get(level);
                l.add(u);
            }

            dfs(u.left, result, level+1);
            dfs(u.right, result, level+1);
        }
    }

    public static treeNode buildBinaryTree(ArrayList<Integer> data, int start , int end){
        if(start > end)
            return null;

        treeNode u = new treeNode(data.get((start+end)/2));
        u.left = buildBinaryTree(data,start,(start+end)/2-1);
        u.right = buildBinaryTree(data,(start+end)/2+1,end);

        return u;   
    }

    public static void inOrderPrint(treeNode v){
        if(v != null){
            inOrderPrint(v.left);
            System.out.println(v.val);
            inOrderPrint(v.right);
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
