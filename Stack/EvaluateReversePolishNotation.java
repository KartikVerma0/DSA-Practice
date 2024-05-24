import java.util.Stack;

/*
 * 150. Evaluate Reverse Polish Notation
 * [https://leetcode.com/problems/evaluate-reverse-polish-notation/description/]
 */

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out
                .println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }

    static int evalRPN(String[] tokens) {
        Stack<String> expStack = new Stack<>();

        int counter = 0;
        while (counter < tokens.length) {
            String element = tokens[counter];
            if (element.equals("+") ||
                    element.equals("-") ||
                    element.equals("*") ||
                    element.equals("/")) {
                String int1 = expStack.pop();
                String int2 = expStack.pop();
                String result = performArithmetic(int2, int1, element);
                expStack.push(result);
            } else {
                expStack.push(element);
            }
            counter++;
        }

        return Integer.valueOf(expStack.pop());
    }

    static String performArithmetic(String int1, String int2, String operator) {
        int firstInteger = Integer.valueOf(int1);
        int secondInteger = Integer.valueOf(int2);
        int result = 0;
        if (operator.equals("+")) {
            result = firstInteger + secondInteger;
        } else if (operator.equals("-")) {
            result = firstInteger - secondInteger;
        } else if (operator.equals("*")) {
            result = firstInteger * secondInteger;
        } else if (operator.equals("/")) {
            result = firstInteger / secondInteger;
        }
        return Integer.toString(result);
    }
}
