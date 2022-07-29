package simpleDifficulty;

import dataStructure.TreeNode;

public class p101 {
    long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
        p101 t = new p101();
        /**
         *      32
         *    26  47
         *  19       56
         *    27
         * **/
        TreeNode bottom1 = new TreeNode(27, null, null);
        TreeNode bottom2 = new TreeNode(19, bottom1, null);
        TreeNode right = new TreeNode(26, null, bottom2);
        TreeNode bottom4 = new TreeNode(27, null ,null);
        TreeNode bottom3 = new TreeNode(19, null ,bottom4);
        TreeNode left = new TreeNode(26, bottom3, null);
        TreeNode root = new TreeNode(32 , left, right);
        System.out.println(t.isSymmetric(root));
    }
    public boolean recursionCompare(TreeNode left, TreeNode right){
        if(left == null || right == null || left.val != right.val)  //一边有一边为空，或两边值不等，则返回false
            return false;
        boolean a = true, b = true;
        if(left.right != null || right.left != null)        //这里记为当左右任一方不为空则进行递归，当进入下一层时，如果只有一方有值一方为空，则返回false
            a = recursionCompare(left.right, right.left);   //比较左边的左节点与右边的右节点，左边的右节点与右边的左节点
        if(left.left != null || right.right != null)
            b = recursionCompare(left.left, right.right);
        if(a == false || b == false)        //如果任意一边不对称，则返回false
            return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.right == null && root.left == null))
            return true;
        return recursionCompare(root.left, root.right);     //我们用left，right指针，同时遍历左子树与右子树，并递归判断是否对称
    }
//    public boolean isSymmetric(dataStructure.TreeNode root) {
//        if(root == null || (root.left == null && root.right == null))
//            return true;
//        LinkedList<dataStructure.TreeNode> list = new LinkedList<>();
//        list.addLast(root.left);
//        list.addLast(root.right);
//        while(!list.isEmpty()){
//            LinkedList<dataStructure.TreeNode> newlist = new LinkedList<>();
//            while(!list.isEmpty()){
//                if(list.size() < 2) return false;       //当队列中只存在1个值，说明左右数量不对称，直接返回false
//                dataStructure.TreeNode left = list.pop();      //取队头元素
//                dataStructure.TreeNode right = list.removeLast();      //取队尾元素
//                if((left == null || right == null) || left.val != right.val) return false;  //当一方为空一方有值，或双方值不同返回false
//                if(left.right != null || right.left != null){       //左右对称的将节点加入队列
//                    newlist.addFirst(left.right);
//                    newlist.addLast(right.left);
//                }
//                if(left.left != null || right.right != null){
//                    newlist.addFirst(left.left);
//                    newlist.addLast(right.right);
//                }
//            }
//            list = newlist;     //我们每次使用list表示当前遍历节点，newlist存放他们的子节点，遍历完后，再把子节点队列赋给list开始下一轮遍历
//        }
//        return true;
//    }
}
