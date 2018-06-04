import java.util.HashMap;

public class word_search{
    static boolean [][] visited;
    public static void main(String args[]){
        char [][] board ={{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};


        String output = (findWord(board, args[0])) ? "Found." : "Mot Found.";
        System.out.println(output);     
    }

    public static boolean findWord(char [][] board, String word){
        visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++){
                if(check(board, i, j, word, 0))
                    return true;
            }

        return false;

    }

    public static boolean check(char [][] board, int i, int j, String word, int idx){
        if(idx == word.length())
            return true;

        if(i<0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        if(check(board, i-1, j, word, idx+1) || 
           check(board, i+1, j, word, idx+1) ||
           check(board, i, j-1, word, idx+1) ||
           check(board, i, j+1, word, idx+1))
            return true;

        
        visited[i][j] = false;
        return false;
    }
}



