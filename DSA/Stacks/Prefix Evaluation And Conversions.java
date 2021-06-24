import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    
    int n = exp.length();
    HashMap<Character, Integer> sign = new HashMap<>();
    sign.put('+', 0);
    sign.put('-', 0);
    sign.put('*', 1);
    sign.put('/', 1);
    
    for(int i=n-1; i>=0; i--)
    {
        char ch = exp.charAt(i);
        
        if( ch != ' ' )
        {
            if( sign.containsKey(ch) )
            {
                // perform operation
                // value stack
                int v1 = value.pop();
                int v2 = value.pop();
                int res = computeRes(v1, v2, ch);
                value.push(res);
                
                // infix
                String e1 = infix.pop();
                String e2 = infix.pop();
                infix.push("(" + e1 + ch + e2 + ")");
                
                // postfix
                e1 = postfix.pop();
                e2 = postfix.pop() ;
                postfix.push(e1 + e2 + ch);
            }
            else
            {
                // push elements
                infix.push(ch + "");
                postfix.push(ch + "");
                value.push(ch - '0');
            }
        }
    }
    
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());
    
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