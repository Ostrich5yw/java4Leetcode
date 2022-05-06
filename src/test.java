import classicalProblem.Sort.temp;
import dataStructure.ListNode;
import dataStructure.MinStack;
import dataStructure.TreeNode;

import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.E;
import static java.lang.Math.decrementExact;
import static util.print.printArray1D;
import static util.print.printArray1D1;

public class test {
    public static void main(String[] args) {
        test t = new test();

        System.out.println(t.permute(new int[]{1,2,3}));

    }
    public int DFS(List<List<Integer>> res, List<Integer> now, boolean[] marks, int[] nums){
        if(now.size() == nums.length){
            List<Integer> list = new ArrayList<>();
            list.addAll(now);
            res.add(list);
            return 0;
        }
        for(int i = 0;i < nums.length;i ++){
            if(!marks[i]){
                now.add(nums[i]);
                marks[i] = true;
                DFS(res, now, marks, nums);
                now.remove(now.size() - 1);
                marks[i] = false;
            }
        }
        return 0;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        DFS(list, now, new boolean[nums.length], nums);
        return list;
    }

}

