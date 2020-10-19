package oldProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  递归求解
 *  注意本题中出现的java赋值问题
 *
 * **/
public class thirtynine {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        thirtynine t = new thirtynine();
        System.out.println(t.combinationSum(new int[]{2,7,6,3,5,1}, 9));
    }
    public int findmaxtar(int[] candidatestemp, List<Integer> existlist, int toTarNum,int nowPos){
        if(toTarNum == 0) {     //为0时，说明当前existlist之和等于target
            /**
             * 不能直接res.add（existlist），因为这样做相当于把existlist的引用添加给res。那么之后existlist变化时也会更改res的值
             * 要用下面两种方法给res赋值
             * **/
            List<Integer> temp = new ArrayList<>(existlist);
//            for (int i:existlist) {
//                temp.add(i);
//            }
            res.add(temp);
            return 1;
        }
        for(int i = nowPos;i < candidatestemp.length;i ++){
            int temp = candidatestemp[i];
            if (i - 1 >= 0 && candidatestemp[i - 1] == candidatestemp[i])
                //对于1，1，2这样的数组，由于题中明确一个数字可以使用n次，所以只需要使用第一个1，之后的1直接跳过
                continue;
            /**
             * for循环加递归，有点像广度搜索？existlist.add  递归  exist.remove------这个结构简直就是广度搜索！
             * **/
            if(temp <= toTarNum) {
                existlist.add(temp);            //将temp加入当前数组，之后再在此基础上，继续递归
                findmaxtar(candidatestemp, existlist, toTarNum - temp, i);  //这里传入的是i而不是i+1，也是因为一个数字可以使用n次
                existlist.remove(existlist.size()-1);   //递归过后，记得删除加入的temp，使下一次for正确循环

            }else
                break;
        }
        return 0;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);            //记得给数组排序
        findmaxtar(candidates, list, target, 0);
        //candidates是问题给出的数组，existlist是当前满足条件(toTarNum<=target)的数组，toTarNum是和目标的差值，nowPos是当前遍历到的candidates位置
        return res;
    }
}

