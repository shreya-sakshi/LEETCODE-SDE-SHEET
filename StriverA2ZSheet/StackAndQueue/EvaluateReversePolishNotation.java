package StackAndQueue;

import java.util.*;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {

                int b = st.pop(); // second operand
                int a = st.pop(); // first operand

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else { // division
                    result = a / b;
                }

                st.push(result);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    // ✅ main method
    public static void main(String[] args) {

        String[] tokens = {
                "10", "6", "9", "3", "+", "-11",
                "*", "/", "17", "+", "5", "+"
        };

        EvaluateReversePolishNotation obj =
                new EvaluateReversePolishNotation();

        System.out.println(obj.evalRPN(tokens));
    }
}
