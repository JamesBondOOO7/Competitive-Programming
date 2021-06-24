import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
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
            if( sign.containsKey(ch) )
            {
                // perform operation
                // value stack
                int v2 = value.pop();
                int v1 = value.pop();
                int res = computeRes(v1, v2, ch);
                value.push(res);
                
                // infix
                String e2 = infix.pop();
                String e1 = infix.pop();
                infix.push("(" + e1 + ch + e2 + ")");
                
                // prefix
                e2 = prefix.pop();
                e1 = prefix.pop() ;
                prefix.push(ch + e1 +e2);
            }
            else
            {
                // push elements
                infix.push(ch + "");
                prefix.push(ch + "");
                value.push(ch - '0');
            }
        }
    }
    
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
    
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