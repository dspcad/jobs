import java.util.Random;

public class insertionSort_ex{
  public static void main(String args[]){
    System.out.println("The input size: "+args[0]);
    int n = Integer.valueOf(args[0]).intValue();
    int [] data = new int[n];

    Random rand = new Random();

    for(int i=0;i<n;i++){
      data[i] = rand.nextInt(10*n);
      System.out.printf("%4d ", data[i]);
    }
    System.out.println("");
    
    //for(int i=1;i<n;i++){
    //  int key = data[i];

    //  int j=i-1;
    //  while(j >=0 && key < data[j]){
    //    data[j+1] = data[j];
    //    j--;
    //  }

    //  data[j+1] = key;
    //}

    insertion_recur(data,data.length);

    for(int i=0;i<n;i++)
      System.out.printf("%4d ", data[i]);
    System.out.println("");

  }

  public static void insertion_recur(int [] A, int n){
    if(n>1){
      int key = A[n-1];
      insertion_recur(A, n-1);      

      int i= n-2;
      while(i>=0){
        if(key<A[i])
          A[i+1] = A[i];
        else
          break;

        i--;
      }

      A[i+1] = key;
    }
  }
}
