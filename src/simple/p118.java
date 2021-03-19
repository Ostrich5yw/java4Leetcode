package simple;

import java.util.ArrayList;
import java.util.List;

public class p118 {
    public static void main(String[] args) {
        p118 t = new p118();
        System.out.println(t.generate(1));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) return list;
        List<Integer> first = new ArrayList<Integer>(){{add(1);}};
        list.add(first);
        for(int i = 1;i < numRows; i ++){
            List<Integer> templist = new ArrayList<>();
            List<Integer> prelist = list.get(list.size() - 1);
            templist.add(1);
            for(int j = 0;j < i - 1;j ++){
                int a = prelist.get(j);
                int b = prelist.get(j + 1);
                templist.add(a + b);
            }
            templist.add(1);
            list.add(templist);
        }
        return list;
    }
}
