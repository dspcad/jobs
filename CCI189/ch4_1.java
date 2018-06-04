import java.util.ArrayList;
import java.util.LinkedList;

public class ch4_1{
    public static void main(String args[]){
        System.out.println("Route between two nodes.");
        int src = Integer.valueOf(args[0]).intValue();
        int sink = Integer.valueOf(args[1]).intValue();

        graph g = new graph(6);
        
        graphNode n0 = new graphNode(0);
        graphNode n1 = new graphNode(1);
        graphNode n2 = new graphNode(2);
        graphNode n3 = new graphNode(3);
        graphNode n4 = new graphNode(4);
        graphNode n5 = new graphNode(5);

        g.addNode(n0);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);

        g.addEdge(n0,n5);
        g.addEdge(n0,n4);
        g.addEdge(n0,n1);
        g.addEdge(n1,n4);
        g.addEdge(n1,n3);
        g.addEdge(n2,n1);
        g.addEdge(n3,n2);
        g.addEdge(n3,n4);

        g.printGraph();

        bfs(g, src, sink);

        dfs(g);

        dfs_single_src(g, src, sink);

        graphNode u = g.nodeList.get(sink);
        System.out.println("===== Route =====");
        while(u != null){
            System.out.println("Vertex "+u.name);
            u = u.predecessor;
        }
        
    }

    public static void dfs_single_src(graph g, int src, int sink){
        for(graphNode elem : g.nodeList)
            elem.visited = false;

        dfs_single_src_visited(g, g.nodeList.get(src), g.nodeList.get(sink));
    }

    public static void dfs_single_src_visited(graph g, graphNode u, graphNode v){
        u.visited = true;
        for(graphNode elem : g.adjList.get(u.name)){
            if(!elem.visited){
                if(elem.name == v.name){
                    elem.predecessor = u;
                    System.out.println("Arrives at Sink: Vertex "+v.name);
                }
                else{
                    elem.predecessor = u;
                    dfs_single_src_visited(g, elem, v);
                }
            }
        }
    }

    public static void dfs(graph g){
        for(graphNode elem : g.nodeList)
            elem.visited = false;

        for(graphNode elem : g.nodeList)
            if(!elem.visited)
                dfs_visited(g, elem);
    }

    public static void dfs_visited(graph g, graphNode u){
        u.visited = true;
        System.out.println("Vertex "+u.name);

        for(graphNode elem : g.adjList.get(u.name)){
            if(!elem.visited){
                elem.predecessor = u;
                dfs_visited(g, elem);
            }
        }
    }

    public static void bfs(graph g, int src, int sink){
        myQueue q = new myQueue();

        for(graphNode elem : g.nodeList)
            elem.visited = false;

        q.enqueue(g.nodeList.get(src));

        while(!q.isEmpty()){
            graphNode u = q.dequeue();
            u.visited = true;

            if(u.name == sink){
                graphNode v = u;
                System.out.println("===== Route =====");
                while(v != null){
                    System.out.printf("vertex "+v.name+" <-- ");
                    v = v.predecessor;
                }
                System.out.println("Root");
            }
            //System.out.println("Node "+u.name);
            for(graphNode elem : g.adjList.get(u.name)){
                if(!elem.visited){
                    elem.predecessor = u;
                    q.enqueue(elem);
                }
            }

        }
    }

}

class myQueue{
    private LinkedList<graphNode> q;

    public myQueue(){
        this.q = new LinkedList<graphNode>();
    }

    public void enqueue(graphNode node){
        this.q.add(node);
    }

    public graphNode dequeue(){
        return this.q.poll();
    }

    public boolean isEmpty(){
        if(this.q.size() == 0)
            return true;
        else
            return false;
    }
}

class graph{
    public int V;
    public ArrayList<LinkedList<graphNode>> adjList;
    public ArrayList<graphNode> nodeList;

    public graph(int n){
        this.V = n;
        this.adjList = new ArrayList<LinkedList<graphNode>>(n);
        this.nodeList = new ArrayList<graphNode>(n);
        for(int i=0;i<this.V;i++)
            adjList.add(new LinkedList<graphNode>());
    }

    public void addNode(graphNode node){
        this.nodeList.add(node);
    }


    public void addEdge(graphNode src, graphNode sink){
        this.adjList.get(src.name).add(sink);
    }

    public void printGraph(){
        for(int i=0;i<this.V;i++){
            System.out.println("Vertex "+i);
            for(graphNode elem : this.adjList.get(i))
                System.out.printf("  %d -->", elem.name);
            System.out.println("");
        }
    }
}

class graphNode{
    public int name;
    public graphNode predecessor;
    public boolean visited;

    public graphNode(int number){
        this.name = number;
        this.predecessor = null;
        this.visited = false;
    }
}
