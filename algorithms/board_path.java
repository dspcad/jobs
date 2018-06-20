import java.util.LinkedList;

public class board_path{
    public static int count = 0;
    public static void main(String args[]){
        int l = Integer.valueOf(args[0]).intValue();
        int w = Integer.valueOf(args[1]).intValue();

        pathFinder(l,w, l, w);

        System.out.println("The total paths: "+count);

        for(String path : pathPrint(l,w,l,w))
            System.out.println(path);

        int [][] c = towDimPath(l, w);
        System.out.println("The total paths: "+c[l-1][w-1]);
        
        c = twoArrayPath(l);
        System.out.println("The total paths: "+c[(l-1)%2][l-1]);

        int [] d = oneArrayPath(l);
        System.out.println("The total paths: "+d[l-1]);
    }


    public static int [] oneArrayPath(int l){
        int [] boards = new int[l];

        for(int i=0;i<l;i++)
            boards[i] = 1;

        for(int i=1;i<l;i++)
            for(int j=0;j<l;j++){
                if(j==0)
                    boards[j] = 1;
                else
                    boards[j] = boards[j] + boards[j-1];
            }
        
        return boards;
    }


    public static int [][] twoArrayPath(int l){
        int [][] boards = new int[2][l];

        for(int i=0;i<l;i++){
            boards[0][i] = 1;
            boards[1][i] = 1;
        }

        for(int i=1;i<l;i++)
            for(int j=1;j<l;j++){
                boards[i%2][j] = boards[(i-1)%2][j] + boards[i%2][j-1];
            }
     
        return boards;   
    }

    public static int [][] towDimPath(int l, int w){
        int [][] boards = new int[l][w];

        for(int i=0;i<l;i++)
            boards[i][0] = 1;

        for(int j=0;j<w;j++)
            boards[0][j] = 1;

        for(int i=1;i<l;i++)
            for(int j=1;j<w;j++)
                boards[i][j] = boards[i-1][j] + boards[i][j-1];

        return boards;
    }

    public static LinkedList<String> pathPrint(int i, int j, int l, int w){
        LinkedList<String> result = new LinkedList<String>();
        if(i == 1 && j == 1){
            result.addFirst("(1,1)");
            return result;
        }

        if(i>=1 && i<=l){
            LinkedList<String> result_left = pathPrint(i-1, j, l, w);
            for(String elem : result_left)
                result.addFirst("("+i+","+j+") "+elem);
        }

        if(j>=1 && j<=w){
            LinkedList<String> result_up = pathPrint(i, j-1, l, w);
            for(String elem : result_up)
                result.addFirst("("+i+","+j+") "+elem);
        }

        return result;
    }

    public static void pathFinder(int i, int j, int l, int w){
        if(i == 1 && j == 1){
            count++;
            return;
        }

        if(i < 1 || i > l) return;
        if(j < 1 || j > w) return;

        pathFinder(i-1, j, l, w);
        pathFinder(i, j-1, l, w);
        
    }
}
