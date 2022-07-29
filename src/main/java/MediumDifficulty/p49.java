package MediumDifficulty;

import java.util.*;

public class p49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i ++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = String.valueOf(temp);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {res.add(v);});
        return res;
    }
}
