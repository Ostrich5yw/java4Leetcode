package MediumDifficulty;

import java.util.Arrays;
import java.util.Comparator;

public class toOffer45 {
    public String minNumber(int[] nums) {
        String[] nums2 = new String[nums.length];
        for(int i = 0;i < nums.length;i ++){
            nums2[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums2, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        return String.join("", nums2);
    }

}
