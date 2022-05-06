package simpleDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p119 {
    public static void main(String[] args) {
        p119 t = new p119();
        System.out.println(t.getRow(0));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1;i <= rowIndex; i ++){
            List<Integer> templist = new ArrayList<>();
            templist.add(1);
            for(int j = 0;j < i - 1;j ++){
                int a = list.get(j);
                int b = list.get(j + 1);
                templist.add(a + b);
            }
            templist.add(1);
            list = templist;
        }
        return list;
    }
}
