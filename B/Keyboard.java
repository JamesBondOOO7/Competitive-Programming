import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double x = sc.nextDouble();
        sc.nextLine();

        HashMap<Character, ArrayList<int[]>> keyboard = new HashMap<>();
        ArrayList<int[]> shift = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            String str = sc.nextLine();
            for(int j=0; j<str.length(); j++)
            {
                char ch = str.charAt(j);
                
                if( ch == 'S' )
                {
                    int[] xy = new int[2];
                    xy[0] = i;
                    xy[1] = j;
                    shift.add(xy);
                }

                else
                {
                    if( !keyboard.containsKey(ch) )
                    {
                        ArrayList<int[]> chlist = new ArrayList<>();
                        keyboard.put(ch, chlist);
                    }

                    int[] xy = new int[2];
                    xy[0] = i;
                    xy[1] = j;
                    keyboard.get(ch).add(xy);
                }
            }
        }

        // Lets create an uppercase map and store the shortest distance with respect to x
        HashMap<Character, Integer> uppercase = new HashMap<>();
        if( shift.size() != 0 )
        {
            for(Character ch_ : keyboard.keySet() )
            {   
                char ch = (char)ch_;
                boolean found = false;
                for(int[]xy : keyboard.get(ch) )
                {
                    for(int[]s : shift)
                    {
                        double dist = distance(xy[0], s[0], xy[1], s[1]);

                        if( dist <= x)
                        {
                            found = true;
                            break;
                        }
                    }
                    if( found )
                        break;
                }

                ch = (char)(ch - 32);

                if( found )
                uppercase.put(new Character(ch), 0);

                else
                uppercase.put(new Character(ch), 1);
            }
        }

        int q = sc.nextInt();
        sc.nextLine();
        String query = sc.nextLine();
        int ans = 0;
        for(int i=0; i<q; i++)
        {
            char ch = query.charAt(i);

            if( uppercase.containsKey(ch) )
            {
                ans += uppercase.get(ch);
            }
            else if( !keyboard.containsKey(ch) )
            {
                ans = -1;
                break;
            }
        }

        System.out.println(ans);
    }

    public static double distance(int x1, int x2, int y1, int y2)
    {
        return Math.pow( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) , 0.5);
    }
}