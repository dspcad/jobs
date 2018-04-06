

public class newton{
    public static void main(String args[]){
        double a = Double.valueOf(args[0]).doubleValue();
        int n = Integer.valueOf(args[1]).intValue();
        double x = Double.valueOf(args[2]).doubleValue();
        

        System.out.println("Real number: "+a);
        System.out.println("Loop count: "+n);
        System.out.println("Initial value: "+x);

        for(int i=0;i<n;i++){
            x = x - (x*x-a)/(2*x);
            System.out.println("Iterated value: "+x);
        }
        
 
        System.out.printf("Square root of %f: %f\n", a, x);
    }

}
