package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllGroup {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        FindAllGroup t = new FindAllGroup();
        System.out.println(t.subsetsWithDup(new int[]{1, 2, 2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length - 1;
        for(int i = 0;i < (2 << len);i ++){                     //总共会有多少种组合，3个数字，就会有8种，2个数字，就会有4种
            List<Integer> templist= new ArrayList<>();
            for(int j = 0;j <= len;j ++){                       //依次鉴定0-len位
                /**
                 * 现有数组8，9  取其所有排列 即[],[9]，[8]，[8,9]
                 * 对于00，01，10，11(分别表示)上述四种情况(1代表对应位取，0代表对应位不取)
                 * 对其与01，10(分别用来鉴定是否取第1位，是否取第0位)相与
                 * 00 -> 00,00   01 -> 01,00  10 -> 00,10  11 -> 01,10
                 * 可以看到，如果与01或10相与后，还是01或10，则代表取对应位，即将对应位加入templist数组
                 * **/
                if(((1 << j) & i )== (1 << j)){
                    templist.add(nums[j]);
                }
            }
            list.add(templist);
        }
        return list;
    }
}
