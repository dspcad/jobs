

public class kmp{
    public static void main(String args[]){
        int [] num1 = {1,2,3,4,5};
        int [] num2 = {2,3,4,7,6};
        int max = Integer.MIN_VALUE;
        int max_idx = 0;

        for(int i=0;i<num1.length;i++){
            int count = 0;
            int j = 0;
            while(i+j<num1.length && j<num2.length){
                if(num1[i+j] != num2[j])
                    break;
                else
                    count++;

                j++;
            }

            if(count > max){
                max_idx = i;
                max = count;
            }
        }
 
        System.out.println("The index: "+max_idx);    
        System.out.println("Length: "+max);    
    }
}
