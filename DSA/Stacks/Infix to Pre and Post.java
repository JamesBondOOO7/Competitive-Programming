import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    int n = exp.length();
    HashMap<Character, Integer> sign = new HashMap<>();
    sign.put('+', 0);
    sign.put('-', 0);
    sign.put('*', 1);
    sign.put('/', 1);
    
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    for(int i=0; i<n; i++)
    {
        char ch = exp.charAt(i);
        
        if( ch != ' ')
        {
            if( ch == '(' )
            {
                operators.push(ch);
            }
            else if( ch == ')')
            {
                while( operators.peek() != '(' )
                {
                    char op = operators.pop();
                    
                    // for prefix
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    String res = op + v1 + v2;
                    pre.push(res);
                    
                    // for postfix
                    v2 = post.pop();
                    v1 = post.pop();
                    res = v1 + v2 + op;
                    post.push(res);
                    
                }
                operators.pop();  // pop '('
            }
            else if( sign.containsKey(ch))
            {
                while( !operators.isEmpty() && operators.peek() != '(' && sign.get(operators.peek()) >= sign.get(ch))
                {
                    char op = operators.pop();
                    
                    // for prefix
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    String res = op + v1 + v2;
                    pre.push(res);
                    
                    // for postfix
                    v2 = post.pop();
                    v1 = post.pop();
                    res = v1 + v2 + op;
                    post.push(res);
                }
                
                
                operators.push(ch);
            }
            else
            {
                pre.push(ch + "");
                post.push(ch + "");
            }
        }
    }
    
    // System.out.println(pre);
    // System.out.println(post);
    // System.out.println(operators);
    
    while( !operators.isEmpty() )
    {
        char op = operators.pop();
    
        // for prefix
        String v2 = pre.pop();
        String v1 = pre.pop();
        String res = op + v1 + v2;
        pre.push(res);
        
        // for postfix
        v2 = post.pop();
        v1 = post.pop();
        res = v1 + v2 + op;
        
        post.push(res);
        
        // System.out.println(pre);
        // System.out.println(post);
    }
    
    System.out.println(post.pop());
    System.out.println(pre.pop());
 }
}