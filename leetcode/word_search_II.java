import java.util.HashMap;
import java.util.ArrayList;

public class word_search_II{
    public static void main(String args[]){
        String [] words = {"oath","pea","eat","rain","easy"};
        char [][] board = {{'o','a','a','n'},
                           {'e','t','a','e'},
                           {'i','h','k','r'},
                           {'i','f','l','v'}};

        ArrayList<String> result = new ArrayList<String>();
        trie t = new trie();

        for(int i=0;i<words.length;i++)
            t.insert(words[i]);

        t.printTrie(t.root);

        //for(int i=0;i<board.length;i++)
        //    for(int j=0;j<board[i].length;j++){
        //        check(board, i, j, t.root,)
        //    }
    }
}

class trieNode{
    public HashMap<Character,trieNode> children = new HashMap<Character,trieNode>();
    public boolean finished;
    public String found_word;

    public trieNode(){
        this.children = new HashMap<Character,trieNode>();
        this.finished = false;
        this.found_word = null;
    }
}

class trie{
    public trieNode root;

    public trie(){
        this.root = new trieNode();
    }

    public void insert(String word){
        trieNode u = this.root;
        trieNode v;;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(u.children.containsKey(c)){
                u = u.children.get(c);
            }
            else{
                v = new trieNode();
                u.children.put(c, v);
                u = v;
            }

            if(i == word.length()-1){
                u.finished = true;
                u.found_word = word;
            }
       
        }
    }

    public void printTrie(trieNode u){
        if(!u.finished)
            for(Character c : u.children.keySet()){
                System.out.println(c);
                printTrie(u.children.get(c));
            }
        else{
            System.out.println(u.found_word);
            System.out.println("========");
        }
    }
}
