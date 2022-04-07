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
        System.out.println(t.search(new int[]{3,1 }, 1));
    }
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        for(;left + 1 <= right && nums[left] < nums[left+1];left ++){}
        if(left == right){
            left = 0;
        }else
            if(nums[right] >= target){
                left ++;
            }else{
                right = left;
                left = 0;
            }
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid - 1;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
}

