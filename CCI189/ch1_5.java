

public class ch1_5{
    public static void main(String args[]){
        String s1 = args[0];
        String s2 = args[1];

        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);


        if(oneAway(s1,s2))
            System.out.println("True");
        else
            System.out.println("False");
    }



    private static boolean oneAway(String s1, String s2){
        int sel = s1.length() - s2.length();

        if(sel == 0)
            return checkReplacement(s1,s2); 
        else if(sel == 1)
            return checkDeletion(s1,s2);
        else if(sel == -1)
            return checkDeletion(s2,s1);
        else
            return false;
    }

    private static boolean checkDeletion(String long_s, String short_s){
        int i = 0;
        int j = 0;

        while(j < long_s.length() && i < short_s.length()){
            if(long_s.charAt(j) == short_s.charAt(i)){
                i++;
                j++;
            }
            else{
                j++;
                if(j-i > 1)
                    return false;

            }
        }

        return true;
    }


    private static boolean checkReplacement(String s1, String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;

            if(count > 1)
                return false;
        }

        return true;
    }
}
