import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class k_closest_for_2D{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int k = Integer.valueOf(args[1]).intValue();
        Random rn = new Random();        

        ArrayList<two_values> list = new ArrayList<two_values>();

        for(int i=0;i<n;i++)
            list.add(new two_values(rn.nextInt(100*n), rn.nextInt(100*n)));

        System.out.println(list);
        //System.out.println("distance: "+a.computeDistance());

        Collections.sort(list,new TwoValueComparator());
   
        System.out.println("===== Result =====");
        for(int i=0;i<k;i++)
            System.out.println(list.get(i));
    }


}

class two_values{
    public int x;
    public int y;

    public two_values(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int computeDistance(){
        return this.x*this.x+this.y*this.y;
    }

    public String toString(){
        return new String("("+this.x+","+this.y+")");
    }
}


class TwoValueComparator implements Comparator<two_values> {
    @Override
    public int compare(two_values a, two_values b) {
        return a.computeDistance()-b.computeDistance();
    }
}
