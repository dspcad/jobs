import java.util.ArrayList;

public class recursive{
    public static void main(String args[]){
        ArrayList<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");

        System.out.println(recusrivePrint(a).size()); 
        System.out.println(recusrivePrint(a)); 
    }

    public static ArrayList<String> recusrivePrint(ArrayList<String> in){
        ArrayList<String> result = new ArrayList<String>();

        if(in.size() == 1)
            result.add(in.get(0));
        else{
            ArrayList<String> b = new ArrayList<String>();
            for(int i=0;i<in.size();i++){
                String prefix = in.get(i);
                for(int j=0;j<in.size();j++)
                    if(j != i)
                        b.add(in.get(j));

                ArrayList<String> tmp = recusrivePrint(b);
                for(String elem : tmp)
                    result.add(prefix+elem);
 
                b.clear();
            }
        }
        return result;
    }
}
