
public class removeDuplicates{
    public static void main(String args[]){
        int [] nums = {2,4,2,10,1,4,3,3};
  
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
            System.out.printf(" %d", nums[i]);

        System.out.println("");

        int prev = nums[0];
        int j = 0;
        boolean duplicate;
        for(int i=1;i<nums.length;i++){
            if(prev != nums[i]){
                prev = nums[i];
                j++;
                swap(nums, i, j);
            }
            else
                prev = nums[i];

        }

        for(int i=0;i<nums.length;i++)
            System.out.printf(" %d", nums[i]);

        System.out.println("");

        System.out.println("length: "+j+1);
    }


    private static void quickSort(int []A, int start, int end){
        if(start < end){
            int pivot = A[end];
            int i = start -1;
            int j = start;

            while(j<end){
                if(A[j] <= pivot){
                    i++;
                    swap(A, i, j);
                }
                j++;
            }
            swap(A, i+1, end);

	    quickSort(A, 0, i);
            quickSort(A, i+2, end);
        }
    }

    private static void swap(int []A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
