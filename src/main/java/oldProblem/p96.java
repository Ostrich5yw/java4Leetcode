package oldProblem;


public class p96 {
    public static void main(String[] args) {
        p96 t = new p96();
        System.out.println(t.numTrees(4));
    }
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1; num[1] = 1;             //注意这里，虽然0个节点是可能有的情况是0种，但放在子树中，比如以1为根，n=3时，应该有  1         1
        // 因为下面的点乘是计算组合数，所以就算一侧为空也应该视为一种情况                    2         3
        //                                               3     2
        //num[k]记录k个节点时，可以生成的二叉树数量
        /**
         *  可以列出递推式：num[k] = 累加i由1-k (num[i-1] + num[k - i])
         *  即以1-k为根分成左右子树，左子树i-1个节点，右子树k-i个节点
         * **/
        for(int k = 2;k <= n;k ++){
            for(int i = 1;i <= k;i ++){
                num[k] += num[i - 1] * num[k - i];
            }
        }
        return num[n];
    }
}