package MediumDifficulty;

import dataStructure.GraphNode;

import java.util.*;

public class p133 {
        List<String> res = new ArrayList<>();
        int count = 10000000;
        public static void main(String[] args) {
            p133 t = new p133();
            GraphNode n1 = new GraphNode(1);
            GraphNode n2 = new GraphNode(2);
            GraphNode n3 = new GraphNode(3);
            GraphNode n4 = new GraphNode(4);
            n1.neighbors = new ArrayList<GraphNode>(Arrays.asList(n2, n4));
            n2.neighbors = new ArrayList<GraphNode>(Arrays.asList(n1, n3));
            n3.neighbors = new ArrayList<GraphNode>(){{add(n2);add(n4);}};
            n4.neighbors = new ArrayList<GraphNode>(){{add(n1);add(n3);}};

            GraphNode tt = t.cloneGraph(n1);
            tt.neighbors.get(1).neighbors.forEach(ttt -> System.out.println(ttt.val));
//        System.out.println(tt.val);
//        tt.neighbors.forEach(os -> System.out.println(os.val));
//        System.out.println(t.cloneGraph(n1));
        }
        /**
         * 我们从 1 开始，建立新1，且邻居节点有2，4，递归进入2                                 ->新2节点完毕，此时4节点已经在mark中，直接加入新1节点，返回新1节点
         * 建立邻居节点为空的新2节点并加入mark，2邻居节点有1，3，其中1已经在mark中，所以直接加入新2的邻居节点，递归进入3              ->返回新2节点
         * 建立邻居节点为空的新3节点并加入mark，3邻居节点有2，4，其中2已经在mark中，所以直接加入新3的邻居节点，递归进入4              ->返回新3节点
         * 建立邻居节点为空的新4节点并加入mark，4邻居节点有1，3，其中1，3已经在mark中，所以直接加入新4的邻居节点                     ->返回新4节点
         *
         *
         * **/
        public GraphNode recursionClone(GraphNode node, GraphNode[] mark){      //mark[i]记录i节点是否已经被访问过(即不再是null)
            if(node == null)            //确保当图中只有一个节点或无节点时返回正确类型。
                return null;
            GraphNode newNode = new GraphNode(node.val);
            if(mark[node.val] == null)
                mark[node.val] = newNode;
            List<GraphNode> list = node.neighbors;                  //原邻居节点
            ArrayList<GraphNode> newList = new ArrayList<>();       //复制的邻居节点
            for(int i = 0;i < list.size();i ++) {                   //遍历原节点数组
                GraphNode tempNode = list.get(i);
                if(mark[tempNode.val] == null) {                    //如果为空，证明该节点还未被访问过
                    GraphNode sonNode = recursionClone(tempNode, mark);
                    mark[tempNode.val] = sonNode;
                    newList.add(sonNode);                           //将得到的新拷贝值加入邻居节点数组
                } else {                                            //不为空，则说明已经访问过，直接从mark中取出该已经拷贝过的新值即可
                    newList.add(mark[tempNode.val]);
                }
            }
            newNode.neighbors = newList;
            return newNode;                                         //返回拷贝值
        }
        public GraphNode cloneGraph(GraphNode node) {
            GraphNode[] mark = new GraphNode[101];                  //记录对应节点是否被访问过
//        for(int i = 1;i <= 4;i ++)
//            System.out.println(mark[i].val);
//        Arrays.fill(mark, false);
            return recursionClone(node, mark);
        }
/**
 * BFS
 * **/

//    public GraphNode recursionCloneBFS(GraphNode node, GraphNode[] mark){      //mark[i]记录i节点是否已经被访问过(即不再是null)
//        if(node == null)            //确保当图中只有一个节点或无节点时返回正确类型。
//            return null;
//        Deque<GraphNode> totalList = new LinkedList<>();
//        totalList.addLast(node);
//        mark[1] = new GraphNode(1);                               //1节点加入队列，并加入记录数组mark
//        while(!totalList.isEmpty()) {
//            node = totalList.removeFirst();                       //mark中存放的是新节点，totalList存放的是原节点
//            GraphNode newNode = mark[node.val];
//            List<GraphNode> list = node.neighbors;                  //原邻居节点
//            ArrayList<GraphNode> newList = new ArrayList<>();       //复制的邻居节点
//            for (GraphNode tempNode : list) {                   //遍历原节点数组
//                if (mark[tempNode.val] == null) {                    //如果为空，证明该节点还未被访问过
//                    mark[tempNode.val] = new GraphNode(tempNode.val);
//                    totalList.addLast(tempNode);
//                }
//                newList.add(mark[tempNode.val]);                           //将得到的新拷贝值加入邻居节点数组
//            }
//            newNode.neighbors = newList;
//            mark[newNode.val] = newNode;
//        }
//        //mark[newNode.val] = newNode;           //这里没必要再赋一遍值，因为java中赋的是地址指针，第38行赋过之后，后面代码对值的修改，也会相应传到mark[newNode.val]中
//        return mark[1];                                         //返回拷贝值
//    }
//    public GraphNode cloneGraph(GraphNode node) {
//        GraphNode[] mark = new GraphNode[101];                  //记录对应节点是否被访问过
////        for(int i = 1;i <= 4;i ++)
////            System.out.println(mark[i].val);
////        Arrays.fill(mark, false);
//        return recursionCloneBFS(node, mark);
//    }

}
