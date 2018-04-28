import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class findAnagramIndexes {

    public List<Integer> finIndex(String s,String p)
    {
        List<Integer> res = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character ch : p.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int end = 0,begin  = 0, counter = map.size();
        while(end < s.length())
        {
            char ch = s.charAt(end);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0)
                    counter--;
            }
            end++;
            while(counter == 0)
            {
                char temp = s.charAt(begin);
                if(map.containsKey(temp))
                {
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp) > 0)
                        counter++;
                }

                if(end - begin == p.length())
                    res.add(begin);

                begin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        findAnagramIndexes fa = new findAnagramIndexes();
        String s = "abchfhgdhabc";
        String p ="abc";
        List<Integer> res = fa.finIndex(s,p);
        for(Integer i : res)
        {
            System.out.println(i);
        }
    }

}
