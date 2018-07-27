

public class kmp{
    public static void main(String args[]){
        String pattern = "annacanna";
        String target_str = "annbcdanacadsannannacanna";

        int [] overlay_fun = compute_overlay(pattern);

        for(int i=0;i<overlay_fun.length;i++)
            System.out.println(overlay_fun[i]);

        int find_idx = searchPattern(target_str, pattern, overlay_fun);
        System.out.println(target_str.substring(find_idx, target_str.length()));

    }

    public static int searchPattern(String target, String pattern, int [] overlay_fun){
        int pattern_index = 0;
        int target_index = 0;

        int pattern_length = pattern.length();
        int target_length = target.length();

        while(pattern_index < pattern_length && target_index < target_length){
            if(pattern.charAt(pattern_index) == target.charAt(target_index)){
                pattern_index++;
                target_index++;
            }
            else if(pattern_index == 0){
                target_index++;
            }
            else{
                pattern_index = overlay_fun[pattern_index-1]+1;
            }
        }

        if(pattern_index == pattern_length)
            return target_index-pattern_index;
        else 
            return -1;

    }

    public static int [] compute_overlay(String pattern){
        int [] overlay_function = new int[pattern.length()];
        overlay_function[0] = -1;

        for(int i=1;i<pattern.length();i++){
            int index = overlay_function[i-1];

            while(index >=0 && pattern.charAt(i) != pattern.charAt(index+1)){
                index = overlay_function[index];
            }

            if(pattern.charAt(i) == pattern.charAt(index+1))
                overlay_function[i] = index + 1;
            else
                overlay_function[i] = -1;
                
        }

        return overlay_function;
    }
}
