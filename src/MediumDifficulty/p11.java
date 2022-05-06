package MediumDifficulty;

/**
 * @author 5yw
 * @date 2022/3/6 19:35
 */
public class p11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxW = -1;
        while(left < right){
            int tempW = Math.min(height[left], height[right]);
            tempW *= (right - left);
            maxW = Math.max(tempW, maxW);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxW;
    }
}
