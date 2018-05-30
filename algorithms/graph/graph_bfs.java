import java.util.LinkedList;
import java.util.ArrayList;

public class graph_bfs{
    public static void main(String args[]){
        graph g = new graph(8); 
       
        graphNode n0 = new graphNode(0);
        graphNode n1 = new graphNode(1);
        graphNode n2 = new graphNode(2);
        graphNode n3 = new graphNode(3);
        graphNode n4 = new graphNode(4);
        graphNode n5 = new graphNode(5);
        graphNode n6 = new graphNode(6);
        graphNode n7 = new graphNode(7);

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
        g.addEdge(n5,n6);
        g.addEdge(n5,n7);
        g.addEdge(n6,n4);
        g.addEdge(n6,n5);
        g.addEdge(n6,n7);
        g.addEdge(n7,n5);
        g.addEdge(n7,n6);

        g.printGraph();

        BFS(g, n5);
    }

    public static void BFS(graph g, graphNode src){
        src.color = 1;
        src.distance = 0;
        
        myQueue Q = new myQueue();
        Q.enqueue(src);
 
        while(Q.size() != 0){
            graphNode u = Q.dequeue();
            for(graphNode v : g.adjList.get(u.node)){
                if(v.color == 0){
                    v.color = 1;
                    v.distance = u.distance + 1;
                    v.predecessor = u;
                    Q.enqueue(v);
                }
            }
            u.color = 2;
            System.out.println("Vertex "+u.node+" is vistited.");
        }
    }
}

class myQueue{
    public LinkedList<graphNode> l;

    public myQueue(){
        this.l = new LinkedList<graphNode>();
    }

    public void enqueue(graphNode node){
        this.l.add(node);
    }

    public graphNode dequeue(){
        return this.l.poll();
    }

    public int size(){
        return this.l.size();
    }

}

class graph{
    public int V;
    public ArrayList<LinkedList<graphNode>> adjList;

    public graph(int n){
        this.V = n;
        this.adjList = new ArrayList<LinkedList<graphNode>>();

        for(int i=0;i<this.V;i++)
            adjList.add(new LinkedList<graphNode>());
    }

    public void addEdge(graphNode src, graphNode sink){
        this.adjList.get(src.node).add(sink);
    }

    public void printGraph(){       
        for(int i = 0; i < this.V; i++){
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(graphNode elem : this.adjList.get(i)){
                System.out.print(" -> "+elem.node);
            }
            System.out.println("\n");
        }
    }
}



class graphNode{
    public int node;
    public int color;
    public int distance;
    public graphNode predecessor;

    public graphNode(int number){
        this.node = number;
        this.color = 0;
        this.distance = Integer.MAX_VALUE;
        this.predecessor = null;
    }

}
