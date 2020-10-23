package middle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  关键在于如何记录nums数组的变化，如给出1，2，3.我们如果将1作为exist第一位，则进入递归的nums中就是2，3.    将2作为第一位，则进入递归的nums就是，1，3.
 *  所以我们当2作为第一位，则将nums中1，2位置交换，并由start记录1的索引，进入递归时，nums为2，1，3并且start=0，即递归会从1开始遍历，即取到1和3
 *  即(nums数组中，在start之前的数字均已加入exist)
 * **/
public class fortysix {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        fortysix t = new fortysix();
        System.out.println(t.permute(new int[]{1}));
    }
    public int[] changePos(int[] nums, int x, int y){       //交换nums中两数位置
        int temp;
        temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return nums;
    }
    /**
     *
     * nums和start配合，记录当前还能加入exist的数字，exist表示当前已经形成的数组
     * **/
    public int findSequence(int[] nums, List<Integer> exist, int target,int start){
        if(exist.size() == nums.length){                 //如果当前数组长度等于nums长度，说明exist已经加入了nums中所有数字，则将其加入res数组
            List<Integer> list = new ArrayList<>();
            for(int n:exist)
                list.add(n);
            res.add(list);
            return 1;
        }
        start ++;               //start 记录从哪一位开始遍历当前的nums数组(nums数组中，在start之前的数字均已加入exist)
        for(int i = start;i < nums.length;i ++){        //遍历还未加入exist的数字
            /**
             * 广度搜索
             * **/
            exist.add(nums[i]);                         //新数加入exist并改变nums
            changePos(nums, start, i);
            findSequence(nums, exist, target, start);   //加入新数后，向下一层继续递归
            changePos(nums, start, i);                  //还原nums和exist
            exist.remove(exist.size() - 1);
        }
        return 0;
    }
    public List<List<Integer>> permute(int[] nums) {
        int target = nums.length;
        List<Integer> exist =new ArrayList<>();
        int start = 0;
        for(int i = 0;i < target;i ++){                 //若nums为1，2，3，这里做的就是将三个数分别作为exist的首位元素分别进行递归
            exist.add(nums[i]);
            changePos(nums, start, i);
            findSequence(nums, exist, target, start);
            changePos(nums, start, i);
            exist.remove(0);
        }
        return res;
    }
}
