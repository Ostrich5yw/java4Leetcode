package simpleDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p136 {
    List<String> res = new ArrayList<>();
    int count = 10000000;
    public static void main(String[] args) {
        p136 t = new p136();
        int[] gas = new int[]{1, 2, 1, 2, 5};
        System.out.println(t.singleNumber(gas));
    }

    public int singleNumber(int[] nums) {       //位运算法 异或运算
        int res = nums[0];
        for(int i = 1 ;i < nums.length; i ++){
            res ^= nums[i];
        }
        return res;
    }
//    public int singleNumber(int[] nums) {       //哈希表法
//        Set hash = new HashSet<>();
//        for(int num : nums){
//            if(hash.contains(num)){
//                hash.remove(num);
//                continue;
//            }
//            hash.add(num);
//        }
//        return (int)hash.toArray()[0];
//    }
}