package middle;

import java.util.ArrayList;
import java.util.List;
/**
 * 老生常谈的DFS问题
 * **/
public class p77 {
    List<List<Integer>> res = new ArrayList<>();    //结果集
    public static void main(String[] args) {
        p77 t = new p77();
        System.out.println(t.combine(4,2));
    }
    public List<Integer> makeList(List<Integer> list,int now, int n, int k){
        if(list.size() == k) {                      //长度到达k后，加入结果集
            List<Integer> temp = new ArrayList<>();     //注意list不能直接赋值，因为直接res.add(list)加入的是指针
            for(int x:list)
                temp.add(x);
            res.add(temp);
        }
        for(int i = now + 1;i <= n;i ++){               //从now之后的元素中，挑选当前位要加入list的元素
            list.add(i);
            makeList(list, i, n ,k);
            list.remove(list.size() - 1);
        }
        return list;
    }
    public List<List<Integer>> combine(int n, int k){
        for(int i = 1;i <= n;i ++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            makeList(list, i, n , k);               //now记录当前的节点，n记录可以使用1-n的元素，k记录结果集需要多少位
        }                                           //比如当前走到1，2   now记录2，n记录4，k记录3
        return res;                                 //则表示接下来只可以从3，4中选值，凑够3位
    }                                               //走到1，3
                                                    //则表示接下来只可以选4，凑够3位
    /**
     List<Integer> temp = new ArrayList<Integer>();
     List<List<Integer>> ans = new ArrayList<List<Integer>>();

     public List<List<Integer>> combine(int n, int k) {
     List<Integer> temp = new ArrayList<Integer>();
     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     // 初始化
     // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
     // 末尾加一位 n + 1 作为哨兵
     for (int i = 1; i <= k; ++i) {
     temp.add(i);
     }
     temp.add(n + 1);

     int j = 0;
     while (j < k) {
     ans.add(new ArrayList<Integer>(temp.subList(0, k)));
     j = 0;
     // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
     // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
     while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
     temp.set(j, j + 1);
     ++j;
     }
     // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
     temp.set(j, temp.get(j) + 1);
     }
     return ans;
     }
     * **/
}