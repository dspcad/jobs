

public class word_search{
    public static void main(String args[]){
        char [][] board ={{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};

       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[i].length;j++)
               System.out.printf("%c ", board[i][j]);
           System.out.println("");
       }

    }
}
