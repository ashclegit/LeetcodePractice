import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {


    public int getHashId(String word)
    {
        int[] counter = new int[26];
        for(char ch : word.toCharArray())
        {
            counter[ch - 'a']++;
        }

        return Arrays.hashCode(counter);
    }

    public List<List<String>> group (String[] grams)
    {
        HashMap<Integer,List<String>> map = new HashMap<>();

        for(String word : grams)
        {
            int hashId = getHashId(word);
            List<String> group = map.get(hashId);
            if(group == null)
            {
                group = new ArrayList<>();
                map.put(hashId,group);
            }

            group.add(word);
        }
       return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        String[] grams = {"ten","net","ate","eat","tea"};
        groupAnagrams ga = new groupAnagrams();
        System.out.println(ga.group(grams));

    }

}
