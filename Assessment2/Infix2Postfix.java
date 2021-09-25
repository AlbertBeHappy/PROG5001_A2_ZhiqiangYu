import java.util.*;
/**
 * Write a description of class Infix2Postfix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Infix2Postfix
{
    /**
     * check the operator and give a precedence;
     */
    private int checkOperator(char c)
    {
        if (c == '+')
        {
            return 1;
        } else if (c == '-')
        {
            return 1;
        } else if (c == '*')
        {
            return 2;
        } else if (c == '/')
        {
            return 2;
        } else if (c == '!')
        {
            return 3;
        } else
        {
            return -1;
        }
    }
    
    /**
     * convert expression in the infix format to postfix format;
     */
    public String convert(String infix)
    {
        Stack<Character> stack = new Stack();
        String postfix = "";
        for (int i = 0; i < infix.length(); i++)
        {
            char c = infix.charAt(i);
            if (checkOperator(c) > 0)
            {
                //operator;
                while (!stack.isEmpty() && (checkOperator(c) <= checkOperator(stack.peek())))
                {
                    postfix = postfix + stack.pop();
                }
                stack.push(c);
            } else if (c == '(')
            {
                //left parenthesis;
                stack.push(c);
            } else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    postfix = postfix + stack.pop();
                }
                stack.pop();        //take out the left parenthesis from the stack;
            } else 
            {
                //operand;
                postfix = postfix + c;
            }
        }
        
        while (!stack.isEmpty())
        {
            postfix = postfix + stack.pop();
        }
        
        return postfix;
    }
    
    /**
     * the method of evaluate;
     */
    public double evaluate(String postfix)
    {
        Stack<Double> stack = new Stack();
        double result = 0;
        for (int i = 0; i < postfix.length(); i++)
        {
            char c = postfix.charAt(i);
            if (checkOperator(c) > 0)
            {
                double operand1 = Double.parseDouble("" + stack.pop());
                double operand2 = Double.parseDouble("" + stack.pop());
                if (c == '+')
                {
                    result = operand1 + operand2;
                } else if (c == '-')
                {
                    result = operand1 - operand2;
                } else if (c == '*')
                {
                    result = operand1 * operand2;
                } else if (c == '/')
                {
                    result = operand1 / operand2;
                }
                stack.push(result);
            } else
            {
                //c is an operand;
                stack.push(Double.parseDouble("" + c));
            }
        }
        result = stack.pop();
        return result;
    }
    public static void main(String[] args)
    {
        Infix2Postfix i2p = new Infix2Postfix();
        String expression = "1+1";
        String postfix = i2p.convert(expression);
        System.out.println(postfix);
        double result = i2p.evaluate(postfix);
        System.out.println(result);
    }
}
