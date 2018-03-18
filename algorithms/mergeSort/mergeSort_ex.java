import java.util.Random;

public class mergeSort_ex{
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

    sort(data, 0, n/2);
    sort(data, n/2+1, n-1);
    merge(data, 0, n/2, n-1);

    for(int i=0;i<n;i++)
      System.out.printf("%4d ", data[i]);
    System.out.println("");


  }

  
  public static void sort(int [] A, int p, int r){
    if(p < r){
      sort(A,p,(p+r)/2);
      sort(A,(p+r)/2+1, r);
      merge(A,p,(p+r)/2,r);
    }
  }

  public static void merge(int [] A, int p, int q, int r){
    int n1 = q-p+1;
    int n2 = r-q;
    int [] L = new int[n1];
    int [] R = new int[n2];

    for(int i=0;i<n1;i++)
      L[i] = A[p+i];

    for(int i=0;i<n2;i++)
      R[i] = A[q+1+i];

    int i = 0;
    int j = 0;
    while(i<n1 || j<n2){
      if(i==n1){
        A[p+i+j] = R[j];
        j++;
      }
      else if(j == n2){
        A[p+i+j] = L[i];
        i++;
      }
      else{
        if(L[i]<R[j]){
          A[p+i+j] = L[i];
          i++;
        }
        else{
          A[p+i+j] = R[j];
          j++;
        }
      }
    }
  }
}
