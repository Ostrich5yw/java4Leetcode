package MediumDifficulty;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class toOffer115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int len = nums.length;
        int[] recOutNum = new int[len+1];
        Set<Integer>[] set = new Set[len+1];
        for(int i = 1;i <= len;i ++){
            set[i] = new HashSet<>();
        }
        for(int i = 0;i < sequences.length;i ++){
            int[] temp = sequences[i];
            int tempLen = temp.length;
            for(int j = 0;j < tempLen - 1;j ++){
                set[temp[j]].add(temp[j + 1]);
                recOutNum[temp[j+1]] ++;
            }
        }
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 1;i <= len;i ++){
            if(recOutNum[i] == 0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            if(que.size() > 1){
                return false;
            }
            int nowPos = que.poll();
            Set<Integer> nowSet = set[nowPos];
            for(int outNum:nowSet){
                recOutNum[outNum] --;
                if(recOutNum[outNum] == 0){
                    que.add(outNum);
                }
            }
        }
        return true;
    }
}
