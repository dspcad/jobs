import java.util.ArrayList;

public class stair{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]);

        ArrayList<ArrayList<String>> sol = new ArrayList<ArrayList<String>>(n+1);
        for(int i=0;i<=n;i++)
            sol.add(new ArrayList<String>());

        int [] num_walks = new int [n+1];

        num_walks[0] = 1;
        num_walks[1] = 1;

        sol.get(0).add("");
        sol.get(1).add("1");

        for(int i=2;i<=n;i++){
            num_walks[i] = num_walks[i-1] + num_walks[i-2];
            
            //one step
            for(String elem : sol.get(i-1))
                sol.get(i).add(elem+"1");

            //two steps
            for(String elem : sol.get(i-2))
                sol.get(i).add(elem+"2");

        }

        System.out.println("Number of walks: "+num_walks[n]);
        for(String elem : sol.get(n))
            System.out.println("    "+elem);
    }
}
