
public class quicksort_ex{

  public static void main(String[] args){
    int [] input_data1 = {3,2,1};
    int [] input_data2 = {1,2,3};
    int [] input_data3 = {9,8,7,6,5,4,3,2,1,0};
    //int [] input_data3 = {2,3,7,8,1,4,6,9,5};

    //for(int i=0; i<input_data.length;i++)
    //  System.out.format("%d ", input_data[i]);

    //System.out.println("size: "+input_data.length);
    quicksort(input_data1, 0, input_data1.length-1);
    for(int i=0; i<input_data1.length;i++)
      System.out.format("%d ", input_data1[i]);

    System.out.println("");

    quicksort(input_data2, 0, input_data2.length-1);
    for(int i=0; i<input_data2.length;i++)
      System.out.format("%d ", input_data2[i]);

    System.out.println("");

    quicksort(input_data3, 0, input_data3.length-1);
    for(int i=0; i<input_data3.length;i++)
      System.out.format("%d ", input_data3[i]);

    System.out.println("");
  }

  public static void quicksort(int [] target_array, int start, int end){
    if(start < end){
      int i = start-1;
      int j = start;
      int pivot = target_array[end];


      while(j<end){
        if(target_array[j] <= pivot){
          i++;
          swap(target_array,i,j);
        }
        j++;
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
