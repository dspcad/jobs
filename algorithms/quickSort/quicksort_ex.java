
public class quicksort_ex{

  public static void main(String[] args){
    int [] input_data = {2,3,7,8,1,4,6,9,5};

    for(int i=0; i<input_data.length;i++)
      System.out.format("%d ", input_data[i]);

    System.out.println("");
    quicksort(input_data, 0, input_data.length-1);
    for(int i=0; i<input_data.length;i++)
      System.out.format("%d ", input_data[i]);
  }

  public static void quicksort(int [] target_array, int start, int end){
    int i = start;
    int j = end-1;
    int pivot = target_array[end];


    if(start < end){
      while(i<j){
        if(target_array[i] <= pivot){
          i++;
        }
        else{
          swap(target_array,i,j);
          j--;
        }
      }

      swap(target_array,i+1,end);

      quicksort(target_array, 0, i);
      quicksort(target_array, i+2, end);


    }
  }

  public static void swap(int [] target_array, int i, int j){
    int temp_val    = target_array[i];
    target_array[i] = target_array[j];
    target_array[j] = temp_val;
  }
}
