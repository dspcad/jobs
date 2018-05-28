import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Collections;

public class oa_4{
    public static void main(String args[]){
        ArrayList<String> all_tag = new ArrayList<String>();
        ArrayList<subSeq> result = new ArrayList<subSeq>();
        HashSet<String> tag_list = new HashSet<String>();
        HashSet<String> set = new HashSet<String>();

        tag_list.add("made");
        tag_list.add("in");
        tag_list.add("china");

        all_tag.add("made");
        all_tag.add("in");
        all_tag.add("made");
        all_tag.add("in");
        all_tag.add("in");
        all_tag.add("china");
        all_tag.add("made");
        all_tag.add("in");
        all_tag.add("c");
        all_tag.add("b");
        all_tag.add("d");

        boolean sub_start = true;
        int     sub_start_index=0;
        for(int i=0;i<all_tag.size()-tag_list.size();i++){
            set.clear();
            sub_start = true;
            for(int j=i; j<all_tag.size();j++){
                if(tag_list.contains(all_tag.get(j))){
                    set.add(all_tag.get(j));

                    if(sub_start){
                        sub_start_index = j;
                        sub_start = false;
                    }
                }

                if(set.size() == tag_list.size()){
                    result.add(new subSeq(sub_start_index,j-sub_start_index));
                    break;
                }
            }

        }

        //actually, sorting is not necessary and just find the minimum one.
        Collections.sort(result, new subSeqComparator());

        for(subSeq elem : result)
            System.out.printf("[%d %d]\n", elem.index, elem.index+elem.length);
    }

    
}

class subSeq{
    public int index;
    public int length;

    public subSeq(int idx, int len){
        this.index = idx;
        this.length = len;
    }
}

class subSeqComparator implements Comparator<subSeq>{
    @Override
    public int compare(subSeq a, subSeq b){
        return a.length-b.length;
    }
}
