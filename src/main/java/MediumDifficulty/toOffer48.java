package MediumDifficulty;

import java.util.HashSet;
import java.util.Set;

public class toOffer48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 1;
        int quick = 1, slow = 0;
        set.add(s.charAt(slow));
        while(quick < s.length()){
            char c = s.charAt(quick);
            if(set.contains(c)){
                maxLen = Math.max(maxLen, quick - 1 - slow + 1);
                set.remove(s.charAt(slow));
                slow ++;
                continue;
            }
            set.add(c);
            quick ++;
        }
        return Math.max(maxLen, quick - 1 - slow + 1);
    }
}
