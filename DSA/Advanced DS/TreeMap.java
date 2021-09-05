import java.util.*;
public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        map.put(10, 2);
        map.put(20, 3);
        map.put(5, -4);
        map.put(15, 9);
        map.put(25, -1);
        
        System.out.println(map);
        
        for(Integer k : map.keySet())
        {
            System.out.println(k + " --> " + map.get(k));
        }
        
        for(Integer v : map.values())
        {
            System.out.println(v);
        }
    }
}