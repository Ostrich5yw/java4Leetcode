package MediumDifficulty;

import java.util.LinkedList;

public class toOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> list = new LinkedList<>();
        int pp = 0, ps = 0;
        while(pp < popped.length && ps < pushed.length){
            if(!list.isEmpty() && list.getFirst() == popped[pp]){
                list.removeFirst();
                pp ++;
                continue;
            }
            while(ps < pushed.length && pushed[ps] != popped[pp]){
                list.addFirst(pushed[ps ++]);
            }
            if(ps < pushed.length && pushed[ps] == popped[pp]){
                ps ++;
                pp ++;
                continue;
            }
            return false;
        }
        while(!list.isEmpty()){
            if (list.removeFirst() != popped[pp++])
                return false;
        }
        return true;
    }

}
