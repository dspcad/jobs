import java.util.ArrayList;
import java.util.LinkedList;

public class graph_dfs{
    public static void main(String args[]){
        System.out.println("DFS traversal.");

        graph g = new graph(10);
    }
}

class graph{
    public int V;
    public ArrayList<LinkedList<graphNode>> adjList;

    public graph(int n){
        this.V = n;
        this.adjList = new ArrayList<LinkedList<graphNode>>(n);

        for(LinkedList elem : adjList)
            elem = new LinkedList<graphNode>();
    }

    public void addEdge(graphNode src, graphNode sink){
        this.adjList.get(src.name).add(sink);
    }
}

class graphNode{
    public int name;
    public int distance;
    public graphNode predecessor;
    public boolean visited;

    public graphNode(){
        this.name = Integer.MIN_VALUE;
        this.distance = 0;
        this.predecessor = null;
    }

}
