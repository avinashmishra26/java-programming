package company;

/**
 * Created by avinashkumarmishra on 18/11/21.
 */
public class Problem2 {
    // calculate("10 + (20 * 2) - 5")

// +, - ,

    class Calculator {

        public int calculate(int a, int b, char operation) {
            if(operation == '+')
                return a+b;
            else if (operation == '-')
                return a-b;
            else if(operation == '*')
                return a*b;

            throw new IllegalStateException("Operation not support");
        }

    }

    //"0+10+(20*2)-5", 0
    private int getResult(String input, int idx) {

        Calculator c = new Calculator();

        int firstInput = 0;
        int secondInput = 0;
        char operation;

        for( int i = idx; i < input.length() && input.charAt(i) != ')'; i++) {

            operation =  i == 0 ?  '+' : input.charAt(i);

            if(input.charAt(i) == '(') {
                getResult(input, i+1);
            }

            // collect numbers 49 - 47
            while(Character.isDigit(input.charAt(i)) ) {
                secondInput  = 10*secondInput + Integer.parseInt(input.charAt(i)+""); //  - '0')
                i++;
            }

            try {
                firstInput = c.calculate(firstInput, secondInput, operation);
            } catch(IllegalStateException e) {
                return -1; // or throw new exception
            }
            secondInput = 0;

        }

        return firstInput;
    }


}
