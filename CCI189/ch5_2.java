

public class  ch5_2{
    public static void main(String args[]){
        double num = Double.valueOf(args[0]).doubleValue();

        System.out.println("input: "+num);

        int i = 0;
        String result = "";
        while(num != 0.0){
            num *=2;
            if(num >= 1){
                result = result+"1";
                num--;
            }
            else
                result = result+"0";

            if(i == 32){
                System.out.println("ERROR!");
                break;
            }

             
            i++;
        }

        System.out.println("0."+result);
    }
}
