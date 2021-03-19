package middle;

import java.util.ArrayList;
import java.util.List;

public class p131 {
    List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        p131 t = new p131();
        System.out.println(t.partition("aabaa"));
    }
    public boolean isPartition(String tt){          //判断输入串是否为回文
        int start = 0, end = tt.length() - 1;
        while(start < end){
            if(tt.charAt(start) != tt.charAt(end))
                return false;
            start ++;
            end --;
        }
        return true;
    }
    public void sonpartition(String s, int index, List<String> list){               //aabaa     使用快慢指针进行扫描，当扫描到a为回文串，对abaa进行递归，继续搜索
        if(index >= s.length()){                                                    //再依次对 aa，aabaa进行递归
            List<String> templist = new ArrayList<>();
            for(int i = 0;i < list.size();i ++){
                templist.add(list.get(i));
            }
            res.add(templist);
        }
        int quick = index + 1, slow = index;
        while(quick <= s.length()){
            String temp = s.substring(slow, quick);
            if(isPartition(temp)){
                System.out.println(temp);
                list.add(temp);
                sonpartition(s, quick, list);
                list.remove(list.size() - 1);
            }
            quick ++;
        }
    }
    public List<List<String>> partition(String s) {
        sonpartition(s, 0, new ArrayList<String>());
        return res;
    }

}
