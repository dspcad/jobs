import java.util.ArrayList;
import java.util.LinkedList;

public class graph_dfs{
    public static void main(String args[]){
        System.out.println("DFS traversal.");

        graph g = new graph(8);

        graphNode n0 = new graphNode(0);
        graphNode n1 = new graphNode(1);
        graphNode n2 = new graphNode(2);
        graphNode n3 = new graphNode(3);
        graphNode n4 = new graphNode(4);
        graphNode n5 = new graphNode(5);
        graphNode n6 = new graphNode(6);
        graphNode n7 = new graphNode(7);

        g.addNode(n0);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);

        g.addEdge(n0,n1);
        g.addEdge(n0,n2);
        g.addEdge(n1,n0);
        g.addEdge(n2,n0);
        g.addEdge(n2,n3);
        g.addEdge(n3,n2);
        g.addEdge(n3,n4);
        g.addEdge(n3,n5);
        g.addEdge(n4,n3);
        g.addEdge(n4,n5);
        g.addEdge(n4,n6);
        g.addEdge(n5,n3);
        g.addEdge(n5,n4);
        g.addEdge(n5,n7);
        g.addEdge(n6,n4);
        g.addEdge(n6,n7);
        g.addEdge(n7,n5);
        g.addEdge(n7,n6);

        g.printGraph();
    }

    public static void dfs(graph g){
        int time = 0;
        for(graphNode elem : g.nodeList){
            if(!elem.visited)
                DFS_VISIT(g, elem, time);
            
        }
    }

    public static void DFS_VIS
}

class graph{
    public int V;
    public ArrayList<graphNode> nodeList;
    public ArrayList<LinkedList<graphNode>> adjList;

    public graph(int n){
        this.V = n;
        this.nodeList = new ArrayList<graphNode>(n);
        this.adjList = new ArrayList<LinkedList<graphNode>>(n);

        for(int i=0;i<n;i++)
            this.adjList.add(new LinkedList<graphNode>());
    }

    public void addEdge(graphNode src, graphNode sink){
        this.adjList.get(src.name).add(sink);
    }

    public void addNode(graphNode node){
        this.nodeList.add(node);
    }

    public void printGraph(){
        for(int i=0;i<adjList.size();i++){
            System.out.println("Vertex "+i+":");
            for(graphNode elem : adjList.get(i))
                System.out.printf("  %d -->  ", elem.name);;
            System.out.println("");
        }
    }
}

class graphNode{
    public int name;
    public int discover_time;
    public int finish_time;
    public graphNode predecessor;
    public boolean visited;

    public graphNode(){
        this.name = Integer.MIN_VALUE;
        this.discover_time = 0;
        this.finish_time = 0;
        this.predecessor = null;
        this.visited = false;
    }

    public graphNode(int number){
        this.name = number;
        this.discover_time = 0;
        this.finish_time = 0;
        this.predecessor = null;
        this.visited = false;
    }

}
