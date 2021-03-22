import dataStructure.GraphNode;

import java.util.*;

public class test {
    List<String> res = new ArrayList<>();
    int count = 10000000;
    public static void main(String[] args) {
        test t = new test();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cos = new int[]{3, 4, 5, 1, 2};
        System.out.println(t.canCompleteCircuit(gas, cos));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] hav = new int[len];
        int nowhav = 0;
        for(int i = 0;i < len;i ++)
            hav[i] = gas[i] - cost[i];
        for(int i = 0;i < len;i ++){
            if(hav[i] < 0)
                continue;
            nowhav = hav[i];
            int j = i + 1 == len ? 0 : i + 1;
            while(j != i){
                nowhav += hav[j];
                if(nowhav < 0)
                    break;
                if(++ j == len)
                    j = 0;
            }
            if(j == i)
                return i;
        }
        return -1;
    }

}