import java.util.ArrayDeque;

class valid_parentheses{
    public static void main(String args[]){
        String input_string = args[0];
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String pop_char = null;
        boolean valid = true;

        for(int i=0;i<input_string.length();i++){
            if(input_string.substring(i,i+1).equals("("))
                stack.push("(");
            else if(input_string.substring(i,i+1).equals("["))
                stack.push("[");
            else if(input_string.substring(i,i+1).equals("{"))
                stack.push("{");
            else if(input_string.substring(i,i+1).equals(")")){
                if(stack.size() == 0){
                    valid = false;
                    break;
                }

                pop_char = stack.pop();
                if(!pop_char.equals("(")){
                    valid = false;
                    break;
                }
            }
            else if(input_string.substring(i,i+1).equals("]")){
                if(stack.size() == 0){
                    valid = false;
                    break;
                }

                pop_char = stack.pop();
                if(!pop_char.equals("[")){
                    valid = false;
                    break;
                }
            }
            else if(input_string.substring(i,i+1).equals("}")){
                if(stack.size() == 0){
                    valid = false;
                    break;
                }

                pop_char = stack.pop();
                if(!pop_char.equals("{")){
                    valid = false;
                    break;
                }
            }

        }


        if(valid && stack.size() == 0)
            System.out.println("Valid!");
        else
            System.out.println("Invalid!");
    }

}
