import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedList<Character> ans = new LinkedList<>();
        boolean rev = false;

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == 'R')
            {
                rev = !rev;
                continue;
            }

            if( rev )
            {
                if(ans.size() == 0)
                    ans.addFirst(ch);

                else if(ans.getFirst() == ch)
                    ans.removeFirst();

                else
                    ans.addFirst(ch);
            }

            else
            {
                if(ans.size() == 0)
                    ans.addLast(ch);

                else if(ans.getLast() == ch)
                    ans.removeLast();

                else
                    ans.addLast(ch);
            }
        }

        
        if( !rev )
        {
            for(Character ele : ans)
                System.out.print(ele + "");
        }
        else
        {
            List<Character> list = new ArrayList<Character>(ans);
            for(int i=list.size()-1; i>=0; i--)
            {
                System.out.print(list.get(i) + "");
            }
        }
    }
}