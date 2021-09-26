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
    private int checkOperator(String c)
    {
        if (c.equals("+") || c.equals("-"))
        {
            return 1;
        } else if (c.equals("*") || c.equals("/"))
        {
            return 2;
        } else if (c.equals("!"))
        {
            return 3;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * convert expression in the infix format to postfix format;
     */
    public String convert(String[] infix)
    {
        Stack<String> stack = new Stack();
        String postfix = "";
        for (int i = 0; i < infix.length; i++)
        {
            String c = infix[i];

            if (checkOperator(c) > 0)
            {
                //operator;
                while (!stack.isEmpty() && (checkOperator(c) <= checkOperator(stack.peek())))
                {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.push(c);
            } else if (c.equals("("))
            {
                //left parenthesis;
                stack.push(c);
            } else if (c.equals(")"))
            {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();        //take out the left parenthesis from the stack;
            } else 
            {
                //operand;
                postfix = postfix + c + " ";
            }
        }
        
        while (!stack.isEmpty())
        {
            postfix = postfix + stack.pop() + " ";
        }
        
        return postfix;
    }

    /**
     * the method of evaluate;
     */
    public double evaluate(String[] postfix)
    {
        Stack<Double> stack = new Stack();
        double result = 0;
        for (int i = 0; i < postfix.length; i++)
        {
            String c = postfix[i];
            if (checkOperator(c) > 0)
            {
                double operand2 = Double.parseDouble("" + stack.pop());
                double operand1 = Double.parseDouble("" + stack.pop());
                if (c.equals("+"))
                {
                    result = operand1 + operand2;
                } else if (c.equals("-"))
                {
                    result = operand1 - operand2;
                } else if (c.equals("*"))
                {
                    result = operand1 * operand2;
                } else if (c.equals("/"))
                {
                    result = operand1 / operand2;
                } else if (c.equals("!"))
                {
                    stack.push(operand1);
                    int k = 1;
                    for (int j = 1; j <= operand2; j++)
                    {
                        k = j * k;
                    }
                    result = k;
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

    /**
     * main method
     */
    
    public static void main(String[] args)
    {
        Infix2Postfix i2p = new Infix2Postfix();
        String expression = "-1 + 2 * ( 3.6 - 3.2 / 2 ) - 2 ! ";
        String postfix = i2p.convert(expression.split(" "));
        System.out.println(postfix);
        double result = i2p.evaluate(postfix.split(" "));
        System.out.println(result);
    }
    

   
}
