

public class factorization{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int a = n;
        System.out.println("The number: "+n);

        
        int bound = (int)Math.sqrt(n);

        for(int i=2;i<=bound;i++){
            while(n%i==0){
                n /=i;
                
                System.out.println("factor: "+i);
            }
        }
        System.out.println("factor: "+n);
        System.out.println("=======================");
        fact(a,2,bound);
    }

    public static void fact(int n, int current_prime, int bound){
        while(n%current_prime==0){
            System.out.println("factor: "+current_prime);
 
            n /= +current_prime;
        }

        if(n == 1) return;

        if(+current_prime < bound)
            fact(n, current_prime+1, bound);
        else 
            return;
    }
}


