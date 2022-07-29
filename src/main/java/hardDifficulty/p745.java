package hardDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p745 {
    class Trie{
        List<Integer> idx;
        Trie children[];
        public Trie(){
            idx = new ArrayList<>();
            children=new Trie[26];
        }
    }

    class WordFilter {
        Trie front = new Trie();
        Trie back = new Trie();
        public WordFilter(String[] words) {
            for(int i = 0;i < words.length;i ++){
                char[] cc = words[i].toCharArray();
                Trie temp = front;
                for(char c : cc){
                    if(temp.children[c - 'a'] == null)
                        temp.children[c - 'a'] = new Trie();
                    temp.children[c - 'a'].idx.add(i);
                    temp = temp.children[c - 'a'];
                }
                temp = back;
                for(int j = cc.length - 1;j >= 0 ;j --){
                    if(temp.children[cc[j] - 'a'] == null)
                        temp.children[cc[j] - 'a'] = new Trie();
                    temp.children[cc[j] - 'a'].idx.add(i);
                    temp = temp.children[cc[j] - 'a'];
                }
            }
        }

        public int f(String pref, String suff) {
            char[] cc = pref.toCharArray();
            Trie temp1 = front;
            for(int i = 0;i < cc.length;i ++){
                temp1 = temp1.children[cc[i] - 'a'];
                if(temp1 == null){
                    return -1;
                }
            }
            cc = suff.toCharArray();
            Trie temp2 = back;
            for(int i = cc.length - 1;i >= 0;i --){
                temp2 = temp2.children[cc[i] - 'a'];
                if(temp2 == null){
                    return -1;
                }
            }
            List<Integer> list1 = temp1.idx;
            List<Integer> list2 = temp2.idx;
            int i = list1.size() - 1;
            int j = list2.size() - 1;
            while (i >= 0 && j >= 0) {
                int prefixIndex = list1.get(i);
                int suffixIndex = list2.get(j);
                if (prefixIndex == suffixIndex) {
                    return prefixIndex;
                } else if (prefixIndex > suffixIndex) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }
    }
}
