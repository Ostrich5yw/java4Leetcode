package oldProblem;
import java.util.*;

/**
 *
 * 不同排序的字符串，也可以转化为char数组进行排序，之后再比较排序后的字符数组是否一致
 *
 * **/
public class p49 {
    public static void main(String[] args) {
        p49 t = new p49();
        System.out.println(t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> list = new ArrayList<>();
//        int[] mark = new int[strs.length];              //记录对应位置的字符串是否已经加入list
//        String[] strssort = new String[strs.length];
//        //strssort存放strs中的排完序的各个元素，因为题目要求最后输出原字符串，所以我们不能将排完序的字符串覆盖掉原字符串
//        for(int i = 0;i < strs.length;i ++){
//            /**
//             *
//             * 关键部分，对字符串排序，使拥有相同元素的字符串排列一致，abc，acb，cba 经过这步操作，全部变为abc
//             *
//             * **/
//            char[] t = strs[i].toCharArray();       //将数组转为char数组，并调用sort对其排序，并写回strssort数组中
//            Arrays.sort(t);
////            strssort[i] = Arrays.toString(t);       //不可以直接t.toString
//            strssort[i] = String.valueOf(t);   //比上面的转换快
////            System.out.println(strs[i]);
//        }
//
//        for(int i = 0;i < strs.length;i ++){            //从第一个元素开始
//            if(mark[i] == 0) {                              //若还未加入list，则为其再创建一个temp，存放它自己还有后续和它一样的字符串
//                List<String> temp = new ArrayList<>();
//                mark[i] = 1;                            //标记为已放入，并加入temp
//                temp.add(strs[i]);
//                for(int j = i + 1;j < strs.length;j ++){    //看它之后是否还有排序和它一样的字符串，均加入temp
//                    if(strs[i].length() != strs[j].length())
//                        continue;
//                    if(strssort[i].equals(strssort[j])){
//                        mark[j] = 1;
//                        temp.add(strs[j]);
//                    }
//                }
//                list.add(temp);                             //temp加入返回列表list
//            }
//        }
//        return list;
//    }
    /**
     *
     * 引入哈希表，只需循环一次就可以得到list。哈希表key存放一个排过序字符串，value存放排完序后等于key字符串的原字符串<"abc",{"acb","bac","cba"}>
     *
     * **/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List> hashmap = new HashMap();
        for(String s: strs){
            char[] t = s.toCharArray();       //将数组转为char数组，并调用sort对其排序，暂存为tt字符串
            Arrays.sort(t);
            String tt = String.valueOf(t);
            if(hashmap.containsKey(tt))     //判断哈希表中是否有这个排列
                hashmap.get(tt).add(s);     //有，则将其加入这个排列对应的List中
            else{                           //否则，为其新建一个键值对
                List<String> temp = new ArrayList<>();
                temp.add(s);                    //注意两处添加的都是s(原始的)，而不是tt(排完序的)
                hashmap.put(tt,temp);
            }
        }
//        System.out.println(hashmap.values());
        for(List l:hashmap.values())             //哈希表中的所有List加入返回列表list中
            list.add(l);
        return list;
    }
}

