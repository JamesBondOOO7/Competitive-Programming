import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();
    int n = exp.length();
    HashMap<Character, Integer> sign = new HashMap<>();
    sign.put('+', 0);
    sign.put('-', 0);
    sign.put('*', 1);
    sign.put('/', 1);
    for(int i=0; i<n; i++)
    {
        char ch = exp.charAt(i);
        
        if( ch != ' ' )
        {
            // System.out.println("Character : " + ch);
            if( sign.containsKey(ch) || ch == '(' || ch == ')' )
            {
                if( ch == '(' )
                    operators.push(ch);
                    
                else if( ch == ')' )
                {
                    while( operators.peek() != '(' )
                    {
                        char op = operators.pop();
                        int c1 = operands.pop();
                        int c2 = operands.pop();
                        
                        int res = computeRes(c2, c1, op);
                        
                        operands.push(res);
                    }
                    operators.pop();  // pop '('
                }
                else
                {
                    while( !operators.isEmpty() && operators.peek() != '(' && sign.get(operators.peek()) >= sign.get(ch))
                    {
                        char op = operators.pop();
                        int c1 = operands.pop();
                        int c2 = operands.pop();
                        
                        int res = computeRes(c2, c1, op);
                        // System.out.println("Result : " + res);
                        operands.push(res);
                    }
                    
                    operators.push(ch);
                }
                // operators.push(ch);
            }
            else
            {
                operands.push((int)( ch - '0' ) );
            }
            
            // System.out.println("Operators : " + operators);
            // System.out.println("Operands : " + operands);
        }
    }
    
    while( operands.size() != 1 )
    {
        char op = operators.pop();
        int c1 = operands.pop();
        int c2 = operands.pop();
        
        int res = computeRes(c2, c1, op);
        // System.out.println("Result : " + res);
        operands.push(res);
    }
    // System.out.println(operators);
    // System.out.println(operands);
    // System.out.println("ANS : " + operands.peek());
    System.out.println(operands.peek());
 }
 
 public static int computeRes(int c1, int c2, char op)
 {
    if( op == '+' )
        return c1 + c2;
        
    else if( op == '-' )
        return c1 - c2;
        
    else if( op == '*')
        return c1 * c2;
        
    else
        return c1 / c2;
 }
}