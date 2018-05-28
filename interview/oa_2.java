import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class oa_2{
    public static void main(String args[]){
        String s = args[0];
        int n = s.length();
        ArrayList<segment> set = new ArrayList<segment>();
        ArrayList<segment> result = new ArrayList<segment>();

        for(int i=0;i<n-1;i++){
            String char_start = s.substring(i,i+1);
            for(int j=i+1;j<n;j++){
                if(char_start.equals(s.substring(j,j+1))){
                    set.add(new segment(i,j));
                    break;
                }
            }
        }

        for(segment elem : set)
            System.out.printf("(%d, %d)", elem.start, elem.end);
        System.out.println();

        segment obj = set.get(0);
        int start = obj.start;
        int end = obj.end;
        boolean contd = false;
        for(int i=1;i<set.size();i++){
            segment tmp = set.get(i);
            if(obj.overlap(tmp)){
                end = tmp.end;
                contd = true;
            }
            else{
                result.add(new segment(start,end));
                contd = false;
            }
            
            obj = tmp;
        }

        if(contd)
            result.add(new segment(start,end));

        Collections.sort(result, new lenComparator());
        for(segment elem : result)
            System.out.printf("(%d, %d)", elem.start, elem.end);
        System.out.println();


    }

}

class segment {
    public int start;
    public int end;

    public segment(int a, int b){
        this.start = a;
        this.end = b;
    }

    public int length(){
        return this.end-this.start;
    }

    public boolean overlap(segment x){
        if(x.start >= this.start && x.start <= this.end)
            return true;

  
        if(x.end >= this.start && x.end <= this.end)
            return true;

        return false;
    }

}


class lenComparator implements Comparator<segment>{
    @Override
    public int compare(segment a, segment b){
        return a.length()-b.length();
    }
}
