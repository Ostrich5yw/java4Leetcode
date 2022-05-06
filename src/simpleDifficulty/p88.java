package simpleDifficulty;


public class p88 {
    public static void main(String[] args) {
        p88 t = new p88();
        int[] nums1 = new int[]{1, 5, 7, 0, 0, 0};
        int[] nums2 = new int[]{0, 4, 6};
        t.merge(nums1, 3, nums2, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tailpoint = m + n - 1;
        m -= 1;n -= 1;
        while (m >= 0 || n >= 0){                       //从尾端依次插入两数组中最大的值(nums1[m]或nums2[n])
            while(m >= 0 && n < 0){
                nums1[tailpoint --] = nums1[m --];
            }
            while(m < 0 && n >= 0){
                nums1[tailpoint --] = nums2[n --];
            }
            if(m >= 0 && n >= 0)
                nums1[tailpoint --] = nums1[m] >= nums2[n] ? nums1[m --] : nums2[n --];
//            System.out.println(m+ " " + n+ " " + tailpoint);
        }
        for(int x:nums1)
            System.out.println(x);
    }
}