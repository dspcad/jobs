import java.lang.Math;

class pairCombinations_1{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();
        int a, b, c, d;

        for(int i=0;i<n;i++){
            a = i;
            for(int j=0;j<n;j++){
                b = j;
                for(int k=0;k<n;k++){
                    c = k;
                    for(int l=0;l<n;l++){
                        d = l;
                        if(a*a*a+b*b*b == c*c*c+d*d*d){
                            System.out.printf("(%d,%d) == (%d,%d)\n", a,b,c,d);
                            break;
                        }
                    }
                }
            }
        }
    }
}
