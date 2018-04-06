import java.lang.Math;

public class n_queens{
    public static void main(String args[]){
        int n = Integer.valueOf(args[0]).intValue();

        int [] col = new int[n];
        for(int i=0;i<n;i++)
            col[i] = -1;

        checkValid(col, 0, n);
    }

    private static void checkValid(int [] col, int row, int n){
        //int [] col = new int[n];
        //for(int i=0;i<n;i++)
        //    col[i] = col_org[i];

        if(row == 0){
            for(int i=0;i<n;i++){
                col[row] = i;
                checkValid(col, row+1, n);
            }
        }
        else if(row == n){
            boolean valid_solution = true;
            //for(int i=0;i<n;i++)
            //    System.out.println("col["+i+"]: "+ col[i]);

            for(int i=0;i<n;i++)
                if(col[i] == -1){
                    valid_solution = false;
                    break;
                }

            if(valid_solution){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(col[i] == j)
                            System.out.printf(" Q");
                        else
                            System.out.printf(" *");
                    }
                    System.out.println("");
                }
                System.out.println("");
            }
        } 
        else{
            for(int i=0;i<n;i++){
                for(int j=0;j<row;j++){
                    boolean valid = true;
                    if(col[j]==i)
                        valid = false;

                    if(Math.abs(row-j) == Math.abs(i-col[j]))
                        valid = false;

                    System.out.println("row: "+row);
                    System.out.println("i: "+i);
                    System.out.println("j: "+j);
                    System.out.println("col[]: "+col[j]);
                    if(valid){
                        col[row] = i;
                        checkValid(col, row+1, n);
                    }
                    else
                        col[row] = -1;
                        

                }
            }
        }
    }
}
