
public class permutation_ex{
  public static void main(String args[]){
    permutation("abcd");
  }

  public static void permutation(String str){
    permutation(str, "");
  }

  public static void permutation(String str, String prefix){
    if(str.length() == 0)
      System.out.println("outcome: "+prefix);
    else{
      for(int i=0;i<str.length();i++){
        String rem = str.substring(0,i) + str.substring(i+1);
        System.out.println("rem: "+rem);
        System.out.println("char: "+str.charAt(i));
        System.out.println("=======================");
        permutation(rem, prefix+str.charAt(i));
      }
    }
  }
}
