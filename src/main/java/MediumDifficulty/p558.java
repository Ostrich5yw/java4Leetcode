package MediumDifficulty;


public class p558 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

        public Node(boolean _val, boolean _isLeaf) {
            val = _val;
            isLeaf = _isLeaf;
        }
    };
    public Node intersect(Node quadTree1, Node quadTree2) {
        //当一棵树为叶节点，且val为1，那么取或肯定等于他自己；当一棵树为叶节点，且val为0，那么取或肯定等于对方
        if((quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && !quadTree2.val)){
            return quadTree1;
        }
        if((quadTree2.isLeaf && quadTree2.val) || (quadTree1.isLeaf && !quadTree1.val)){
            return quadTree2;
        }
        Node tL = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tR = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bL = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bR = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if(tL.isLeaf && tR.isLeaf && bL.isLeaf && bR.isLeaf && tL.val == tR.val && tL.val == bL.val && tL.val == bR.val)
            return new Node(tL.val, true);
        return new Node(false, false, tL, tR, bL, bR);
    }
}
