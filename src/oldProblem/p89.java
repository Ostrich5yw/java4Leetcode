package oldProblem;

import java.util.ArrayList;
import java.util.List;

public class p89 {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        p89 t = new p89();
        t.grayCode(3);
    }
    public int getReverse(int n, int nownum){       //n记录当前数字num可以对哪几位取反，比如3，000就代表三位都可以取反，生成001，010，100
        int newnum = nownum;
        /**
         * 为什么要递归？以3为例
         * 000
         * 001 i=0 => 跳出
         * 011 i=1 => 010 i=0 跳出  (注意这里，之所以递归要返回当前遍历到的新数字，就是因为for循环的下一次取异或是以010为基础，而不是011)
         * 110 i=2 => 111 i=0 跳出  (同时也注意这里,i=0进入递归会直接跳出并返回原数字，即每一次异或都是在上一个newnum的基础上)
         *            101 i=1 => 100 i=0 跳出
         * **/
        for(int i = 0;i < n;i ++){   //数字对第i位取反，实际上就是对1左移i位后的值与该数字取异或(相同取0，不同取1)，即异或始终保持生成的数字与原数字只有1位不相同
            newnum = newnum ^ (1 << i);      //比如111^010得101即只有第二位不同
            list.add(newnum);               //新得到的数字加入list
            newnum = getReverse(i, newnum);     //递归寻找
        }
        return newnum;
    }
    public List<Integer> grayCode(int n) {
        list.add(0);                        //从000开始
        getReverse(n, 0);
        System.out.println(list);
        return list;
    }
}
