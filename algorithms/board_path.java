

public class board_path{
    public static int count = 0;
    public static void main(String args[]){
        int l = Integer.valueOf(args[0]).intValue();
        int w = Integer.valueOf(args[1]).intValue();

        pathFinder(l,w, l, w);

        System.out.println("The total paths: "+count);
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
