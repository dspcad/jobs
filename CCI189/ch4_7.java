import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class ch4_7{
    public static int time_stamp;

    public static void main(String args[]){
        time_stamp = -1;
        graph g1 = new graph();

        graphNode a = new graphNode("a");
        graphNode b = new graphNode("b");
        graphNode c = new graphNode("c");
        graphNode d = new graphNode("d");
        graphNode e = new graphNode("e");
        graphNode f = new graphNode("f");
        graphNode g = new graphNode("g");
        graphNode h = new graphNode("h");

        g1.addNode(a);
        g1.addNode(b);
        g1.addNode(c);
        g1.addNode(d);
        g1.addNode(e);
        g1.addNode(f);
        g1.addNode(g);
        g1.addNode(h);

        g1.addEdge(f,c);
        g1.addEdge(f,b);
        g1.addEdge(f,a);
        g1.addEdge(c,a);
        g1.addEdge(b,a);
        g1.addEdge(b,e);
        g1.addEdge(b,h);
        g1.addEdge(a,e);
        g1.addEdge(d,g);

        g1.printGraph();

        for(graphNode v : g1.adjList.keySet()){
            if(!v.visited)
                DFS(v, g1);
        }
        
        ArrayList<graphNode> list = new ArrayList<graphNode>();
        for(graphNode v : g1.adjList.keySet())
            list.add(v);

        Collections.sort(list, new nodeComparator());

        for(graphNode v : list){
            System.out.println("Node: "+v.name);
            System.out.println("  dicover time: "+ v.discover_time);
            System.out.println("  finish  time: "+ v.finish_time);
            System.out.println("");
        }
    }

    public static void DFS(graphNode u, graph g){
        if(!u.visited){
            time_stamp++;
            u.discover_time = time_stamp;
            for(graphNode v : g.adjList.get(u))
                DFS(v, g);

            time_stamp++;
            u.finish_time = time_stamp;
            u.visited = true;
        }
    }

    
}

class nodeComparator implements Comparator<graphNode>{
    @Override
    public int compare(graphNode n1, graphNode n2){
        return n2.finish_time - n1.finish_time;
    }
}

class graph{
    public HashMap<graphNode, LinkedList<graphNode>> adjList;

    public graph(){
        this.adjList = new HashMap<graphNode, LinkedList<graphNode>>();
    }

    public void addNode(graphNode node){
        this.adjList.put(node, new LinkedList<graphNode>());
    }

    public void addEdge(graphNode src, graphNode sink){
        if(this.adjList.containsKey(src))
            adjList.get(src).add(sink);
        else
            System.out.println("No src node "+src.name);
    }

    public void printGraph(){
        for(graphNode elem : this.adjList.keySet()){
            System.out.println("node "+elem.name+":");
            for(graphNode sink : this.adjList.get(elem))
                System.out.printf("%s  ", sink.name);
            System.out.println("");
        }

    }
}

class graphNode{
    public String name;
    public int discover_time;
    public int finish_time;
    public boolean visited;

    public graphNode(String x){
        this.name = x;
        this.discover_time = 0;
        this.finish_time = 0;
        this.visited = false;
    }
}
