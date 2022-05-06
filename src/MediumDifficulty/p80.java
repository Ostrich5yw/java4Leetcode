package MediumDifficulty;

/**
 * 其实直接0遍历到数组末尾，如果nums[i]==nums[i+1]次数大于2，则数组向前移，不等，则将次数归1。
 * **/
public class p80 {
    public static void main(String[] args) {
        p80 t = new p80();
        System.out.println(t.removeDuplicates(new int[]{0,0,1,1,1,1,2,2,2,3,3,3}));
    }
    public int removeDuplicates(int[] nums) {
        int slow = 0, quick = 0;
        int marknum = 0;int len = nums.length;      //len记录新数组长度
        while(slow < len && quick < len){           //当快慢指针均小于目前新数组长度
            if(nums[quick] == nums[slow]) {         //快慢指针值相同，则快指针向后一个，marknum+1
//                System.out.println(nums[quick] + " " + quick);
                marknum ++;
                quick ++;
            }else{
                /**
                 * 对于 2，2，2，2，3，3
                 * 从第三个2开始，将数组变为2，2，3，3，3，3
                 * 长度变为4
                 * 再从第三个3开始，将数组变为2，2，3，3，0，0
                 * quick，slow指向第一个3
                 * **/
                if(marknum > 2){                            //如果当前数字个数多于2
                    for(int i = quick;i < len;i ++)         //则从这个数字保留2个，从第三个开始将后面数组前移
                        nums[i - marknum + 2] = nums[i];
                    len = len - marknum + 2;                //计算变换后的新数组长度
                    for(int i = len;i < nums.length;i ++)   //数组后面空余的部分用0补全
                        nums[i] = 0;
                }
                quick = quick - marknum + 1;        //quick,slow指针再次指向新数字的起始位置
                slow = quick;
                marknum = 0;
            }
        }
        if(marknum > 2)             //最后一个数字统计完成后，循环直接跳出，所以我们还需单独判断一下最后一个数字个数
            len = len - marknum + 2;
//        System.out.println(len);
        for(int i = 0; i < len;i ++)
            System.out.print(nums[i]);
        System.out.println();
        return len;
    }
}
