package MediumDifficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p40 {
    ArrayList<List<Integer>> list = new ArrayList<>();

    public int findSum(int[] candidates, ArrayList<Integer> existNum,int toNum, int nowPos){
        if(toNum == 0) {
            List<Integer> tt = new ArrayList<>();
            for(int n:existNum) {
                tt.add(n);
            }
            list.add(tt);
            return 0;
        }
//        System.out.println(existNum+ " "+toNum);
        int len = candidates.length;
        for(int i = nowPos + 1;i < len;i ++){
            if(toNum >= candidates[i]){
                if(i != nowPos + 1 && candidates[i] == candidates[i - 1])       //原数组1，2，2，3
                    continue;                                                   //如果已经在i=1时遍历过1，2  那么在i=2时则直接跳过，不再对1，2递归
                existNum.add(candidates[i]);
                findSum(candidates, existNum,toNum - candidates[i], i);
                existNum.remove(existNum.size() - 1);
            }else
                break;
        }
        return 0;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        for(int i = 0;i < len;i ++){
            if(i == 0 || (i > 0 && candidates[i] != candidates[i-1])) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                findSum(candidates, temp, target - candidates[i], i);
            }
        }
        return list;
    }
}
