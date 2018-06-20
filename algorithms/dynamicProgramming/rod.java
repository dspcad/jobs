import java.util.HashMap;

public class rod{
    static HashMap<Integer,Integer> r_tbl = new HashMap<Integer,Integer>();
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();

        int [] tbl = new int[11];
        
        tbl[1]  = 1;
        tbl[2]  = 5;
        tbl[3]  = 8;
        tbl[4]  = 9;
        tbl[5]  = 10;
        tbl[6]  = 17;
        tbl[7]  = 17;
        tbl[8]  = 20;
        tbl[9]  = 24;
        tbl[10] = 30;

        int r = cut_off_price(tbl, n);
        System.out.println("The revenue: "+r);

        mem_cut_off_price(tbl, n);
        System.out.println("The revenue: "+r_tbl.get(n));
    }

    public static void mem_cut_off_price(int [] p, int n){
        int max = Integer.MIN_VALUE;
        int q;

        if(n==0){
            r_tbl.put(n,0);
            return;
        }

        for(int i=1;i<=n;i++){
            if(!r_tbl.containsKey(n-i))
                mem_cut_off_price(p,n-i);
            

            q = p[i]+r_tbl.get(n-i);
            
            if(q > max)
                max = q;
            
        }

        r_tbl.put(n,max);

    }

    public static int cut_off_price(int [] p, int n){
        int max = Integer.MIN_VALUE;
        int q;

        if(n==0)
            return 0;

        for(int i=1;i<=n;i++){
            q = p[i]+cut_off_price(p,n-i);
            if(q > max)
                max = q;
            
        }

        return max;
    }
}
