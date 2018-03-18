public class LCP_ex{
  public static void main(String args[]){
    String [] strs = {"c","acc","ccc"};

    int n = strs.length;
    boolean no_LCP = false;
        
    if(n==1)
      System.out.println("LCP: "+strs[0]);

    for(int i=0;i<n;i++)
      if(strs[i].length() == 0){
        no_LCP = true;
        break;
      }


    if(no_LCP)
      System.out.println("LCP: ");
    else{

      String max_lcp = "";
      
      for(int i=1;i<n;i++){
      
        int j = 0;
        while(j < strs[0].length() && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j))
          j++;

        if(j==0)
          System.out.println("LCP: ");
                   
        if(max_lcp.length() == 0 || strs[i].substring(0,j).length() < max_lcp.length())
          max_lcp = strs[i].substring(0,j);
          
      }
          
      System.out.println("LCP: "+max_lcp);
    }
      
  }
}
