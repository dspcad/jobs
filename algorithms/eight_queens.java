import java.lang.Math;

public class eight_queens{
    public static void main(String args[]){
        int [] col = new int[8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(checkValid(col, i,j))
                    col[i] = j;
            }
        }

        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(col[i]==j)
                    System.out.printf(" Q");
                else
                    System.out.printf(" *");
            }
            System.out.println("");
        }
    }

    private static boolean checkValid(int [] col, int row, int column){
        if(row == 0)
            return true;

        for(int i=0;i<row;i++){
            if(column == col[i])
                return false;

            if(Math.abs(row-i) == Math.abs(column-col[i]))
                return false;
        }

        return true;
    }
}
