import java.lang.StringBuilder;

public class ch1_6{
    public static void main(String args[]){
        String s = args[0];
        char c = s.charAt(0);
        StringBuilder compress_s = new StringBuilder(s.substring(0,1));

        int count = 1;
        System.out.println("input: "+s);
        for(int i=1;i<s.length();i++){
            if(c == s.charAt(i))
                count++;
            else{
                c = s.charAt(i);
                if(count != 1)
                    compress_s.append(count);

                compress_s.append(c);
                count = 1;
            }
        }

        System.out.println("output: "+compress_s.toString());
    }
}
