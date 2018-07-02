

public class ch5_1{
    public static void main(String args[]){
        int left_bit_position = Integer.valueOf(args[0]);
        int right_bit_position = Integer.valueOf(args[1]);

        int allones = ~0;

        int N = -2147483648;
        int M = 19;

        System.out.println("all ones: "+allones);
        System.out.println("N: "+Integer.toBinaryString(N));
        System.out.println("M: "+Integer.toBinaryString(M));

        int mask_bit = clearBits(N, left_bit_position, right_bit_position);
        int result = (mask_bit & N) + (M << right_bit_position);
        System.out.println("Output: "+Integer.toBinaryString(result));
    }

    public static int clearBits(int N, int left_bit_position, int right_bit_position){
        int allones = ~0;
        int shift_all_ones = allones << (left_bit_position+1);
        //int partial_ones = (int)Math.pow(2,right_bit_position)-1;
        int partial_ones = (1<<right_bit_position)-1;
        int clear_bits = shift_all_ones+partial_ones;

        System.out.println("shift all ones: "+Integer.toBinaryString(shift_all_ones));
        System.out.println("partial ones: "+Integer.toBinaryString(partial_ones));
        System.out.println("clear ones: "+Integer.toBinaryString(clear_bits));
     
        return clear_bits;   
    }
}
