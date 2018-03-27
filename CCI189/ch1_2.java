import java.util.Arrays;

public class ch1_2{
    public static void main(String args[]){
        char [] content1 = args[0].toCharArray();
        char [] content2 = args[1].toCharArray();
        for(int i=0;i<content1.length;i++)
            System.out.printf("%d ", (int)content1[i]);
        System.out.println("");

        for(int i=0;i<content2.length;i++)
            System.out.printf("%c ", content2[i]);
        System.out.println("");


        if(content1.length != content2.length)
            System.out.println("NO!");
        else{
            Arrays.sort(content1);
            Arrays.sort(content2);


            if(checkPermutation(content1, content2))
                System.out.println("Yes!");
            else
                System.out.println("NO!");
        }

        
    }

    private static boolean checkPermutation(char [] c1, char [] c2){
        for(int i=0;i<c1.length;i++){
            if(c1[i] != c2[i])
                return false;
        }

        return true;
    }
}
