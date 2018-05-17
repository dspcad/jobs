
public class strStr{
    public static void main(String args[]){
        System.out.println("Haystack: "+args[0]);
        System.out.println("needle: "+args[1]);

        System.out.println("index: "+findIndex(args[0],args[1]));

    }

    private static int findIndex(String haystack, String needle){
        if(needle.length() == 0)
            return 0;
        
        if(haystack.length() < needle.length())
           return -1;

        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            boolean pass = true;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    pass = false;
                    break;
                }
            }

            if(pass)
                return i;
        }

        return -1;

    }
}
