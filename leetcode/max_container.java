import java.util.Random;
import java.lang.Math;

public class max_container{
  public static void main(String args[]){
    System.out.println("The number of numbers: "+args[0]);

    int n = Integer.valueOf(args[0]).intValue();
    int [] data = new int[n];
    int [] idx = new int[n];
    boolean [] marker = new boolean[n];

    Random rand = new Random();

    for(int i=0;i<n;i++){
      data[i] = rand.nextInt(10*n);
      idx[i] = i;
      System.out.printf("%d ", data[i]);
    }
    System.out.println("");



    //int [] data = {1,2};
    //for(int i=0;i<data.length;i++)
    //  System.out.printf("%d ", data[i]);
    //System.out.println("");
   

    quickSort(data, idx, 0, n-1);

    for(int i=0;i<n;i++)
      System.out.printf("%d ", data[idx[i]]);
    System.out.println("");

    for(int i=0;i<n;i++)
      System.out.printf("%d ", idx[i]);
    System.out.println("");

    int max_area = 0;
    int temp_area;
 
    int left  = 0;
    int right = n-1;

    int max_idx = -1;

    for(int i=0;i<n-1;i++){
      marker[idx[i]] = true;
      while(left < n && marker[left])
        left++;

      while(right >=0 && marker[right])
        right--;

      temp_area = data[idx[i]]*maxWidth(left,right,idx[i]);
      marker[idx[i]] = true;
      System.out.printf("temp area: %d  %d  (%d,%d)\n", temp_area, data[idx[i]], left, right);

      if(max_area < temp_area){
        max_area = temp_area;
        max_idx = idx[i];
      }

    }        
 
    System.out.println("Max container: "+max_area);
    System.out.println("index: "+max_idx);

    max_area = 0;
    int left_index = -1;
    int right_index = -1;
    for(int i=0;i<n-1;i++)
      for(int j=i+1;j<n;j++){
        temp_area = Math.min(data[i],data[j])*Math.abs(i-j);
        if(max_area < temp_area){
          max_area = temp_area;
          left_index = i;
          right_index = j;
        }

      }
    System.out.println("Max container: "+max_area);
    System.out.println("index: "+left_index+"  "+right_index);
  }

  private static int maxWidth(int left, int right, int index){
    return Math.max(Math.abs(left-index), Math.abs(right-index));
  }

  private static void quickSort(int [] data, int [] idx, int start, int end){
    int index = partition(data, idx, start, end);
    
    if(start < index - 1){
      quickSort(data, idx, start, index-1);
    }

    if(index +1 < end){
      quickSort(data, idx, index + 1, end);
    }
  }

  private static int partition(int [] data, int [] idx, int start, int end){
    int i=start-1;
    int j=start;
    //System.out.println("Pivot index: "+pivot_idx);
    //System.out.println("Pivot: "+data[pivot_idx]);

    while(j<end){
      if(data[idx[j]]<=data[idx[end]]){
        i++;
        //swap(data, i, j);
        swap(idx, i, j);
      }
        
      j++;


    }

    //swap(data, i+1, end);
    swap(idx, i+1, end);
    return i+1;
  }

  private static void swap(int [] data, int i, int j){
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}
