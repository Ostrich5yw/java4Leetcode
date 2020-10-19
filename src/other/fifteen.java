package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class fifteen {
    public static void main(String[] args){
//        int mark = Integer.MAX_VALUE;
//        Arrays.sort(nums);
//        List<List<Integer>> list= new ArrayList<>();
//        HashMap<ArrayList<Integer>,Integer> hashmap = new HashMap<>();
//        for(int a = 0;a < nums.length-2;a ++)
//            for(int b = a + 1;b < nums.length - 1;b ++)
//                for(int c = b + 1;c <nums.length;c ++){
//                    if(c == nums.length - 1)
//                        mark = Integer.MAX_VALUE;
//                    if(c == mark)
//                        break;
//                    if(nums[a] + nums[b] + nums[c] == 0) {
//                        ArrayList<Integer> arr = new ArrayList<Integer>();
//                        arr.add(nums[a]);
//                        arr.add(nums[b]);
//                        arr.add(nums[c]);
//                        if(hashmap.containsKey(arr))
//                            continue;
//                        list.add(arr);
//                        hashmap.put(arr,0);
//                        mark = c;
//                    }
//                }
        int[] nums = {0,0,0,0};
        int marka = Integer.MAX_VALUE;
        int markb = Integer.MAX_VALUE;
        Arrays.sort(nums);
        List<List<Integer>> list= new ArrayList<>();
        HashMap<ArrayList<Integer>,Integer> hashmap = new HashMap<>();
        for(int a = 0;a < nums.length-2;a ++)
            for(int b = a + 1;b < nums.length - 1;b ++) {
                int temp = -(nums[a] + nums[b]);
                int i = b + 1;
                int j = nums.length - 1;
                while(i <= j){
                    int p = (i + j)/2;
                    if(nums[p] == temp){
                        if(marka != nums[a] || markb != nums[b]){
                            ArrayList<Integer> arr = new ArrayList<Integer>();
                            arr.add(nums[a]);
                            arr.add(nums[b]);
                            arr.add(nums[p]);
                            list.add(arr);
                            marka = nums[a];
                            markb = nums[b];
                        }
//                        if(!hashmap.containsKey(arr)) {
//                            list.add(arr);
//                            hashmap.put(arr,0);
//                        }
                        break;
                    }
                    if(temp > nums[p]) i = p + 1;
                    if(temp < nums[p]) j = p - 1;
                }
            }
        System.out.println(list);
    }
}
