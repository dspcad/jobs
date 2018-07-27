import java.util.ArrayList;

public class matrix_multiplication{
    public static int [][] s = new int[6][6];

    public static void main(String args[]){
        matrix A1 = new matrix(30,35, "A1");
        matrix A2 = new matrix(35,15, "A2");
        matrix A3 = new matrix(15,5, "A3");
        matrix A4 = new matrix(5,10, "A4");
        matrix A5 = new matrix(10,20, "A5");
        matrix A6 = new matrix(20,25, "A6");

        ArrayList<matrix> product = new ArrayList<matrix>();

        product.add(A1);
        product.add(A2);
        product.add(A3);
        product.add(A4);
        product.add(A5);
        product.add(A6);

        System.out.println("The number of calculations: "+matrixChain(product, 0, 5));

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++)
                System.out.printf("%d ", s[i][j]);

            System.out.println("");
        }
          
        printSol(product, s, 0, 5);
        System.out.println("");

        int [][] m = loopMatrixChain(product, s);
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++)
                System.out.printf("%d ", m[i][j]);

            System.out.println("");
        }

    }

    public static int [][] loopMatrixChain(ArrayList<matrix> list, int [][] s){
        int [][] m = new int[list.size()][list.size()];

        for(int i=0;i<list.size();i++)
            m[i][i] = 0;

        int j, q;
        for(int l=2;l<=list.size();l++){
            for(int i=0;i<=list.size()-l;i++){
                j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    q = m[i][k]+m[k+1][j]+list.get(i).r*list.get(k).c*list.get(j).c;
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return m;
    }

    public static void printSol(ArrayList<matrix> list, int [][] s, int i, int j){
        if(i==j)
            System.out.printf("%s", list.get(i).name);
        else{
            System.out.printf("(");
            printSol(list, s, i, s[i][j]);
            printSol(list, s, s[i][j]+1, j);
            System.out.printf(")");
        }
    }

    public static int matrixChain(ArrayList<matrix> list, int i, int j){
        if(i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost = matrixChain(list, i,k)+matrixChain(list, k+1,j) + list.get(i).r*list.get(k).c*list.get(j).c;
            if(cost < min){
                min = cost;
                s[i][j] = k;
            }
        }


        return min;
    }
}


class matrix{
    public int r;
    public int c;
    public String name;

    public matrix(int x, int y, String str){
        this.r = x;
        this.c = y;
        this.name = str;
    }
}
