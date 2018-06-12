import java.util.HashMap;
import java.util.LinkedList;

class ch4_7{
    public static void main(String args[]){
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
    public boolean finish;

    public graphNode(String x){
        this.name = x;
        this.discover_time = 0;
        this.finish_time = 0;
        this.finish = false;
    }
}
