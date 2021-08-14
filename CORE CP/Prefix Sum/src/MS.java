import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MS {
    public static void main(String[] args) {
        String[] arr = {"CAT", "BAT", "RAT", "ACT", "TAB", "ART", "TAR"};
        // print anagrams
        HashMap<String, ArrayList<String>> ANS = new HashMap<>();
        for(String s : arr)
        {
            String sorted_str = base(s);
            if( ANS.containsKey(sorted_str) )
            {
                ANS.get(sorted_str).add(s);
            }
            else
            {
                ANS.put(sorted_str, new ArrayList<String>());
                ANS.get(sorted_str).add(s);
            }
        }

        ArrayList<String> RES = new ArrayList<>();
        for(String str : ANS.keySet() )
        {
            for(String ele : ANS.get(str))
                RES.add(ele);
        }
        System.out.println(RES);
    }

    public static String base(String str)
    {
        // CAT -> ACT, sorted
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);

        String res = "";
        for(char ele : arr)
            res += ele;

        return res;
    }
}
