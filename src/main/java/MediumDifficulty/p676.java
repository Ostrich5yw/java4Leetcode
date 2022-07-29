package MediumDifficulty;


public class p676 {
    class MagicDictionary {
        class dictionaryTree{
            MagicDictionary.dictionaryTree[] dict;
            boolean end;
            public dictionaryTree(){
                dict = new MagicDictionary.dictionaryTree[26];
                end = false;
            }
        }
        MagicDictionary.dictionaryTree head;
        public MagicDictionary() {
            head = new MagicDictionary.dictionaryTree();
        }

        public void buildDict(String[] dictionary) {
            for(String s:dictionary){
                MagicDictionary.dictionaryTree rec = head;
                char[] cc = s.toCharArray();
                for(int i = 0;i < cc.length;i ++){
                    if(rec.dict[cc[i] - 'a'] == null){
                        MagicDictionary.dictionaryTree temp = new MagicDictionary.dictionaryTree();
                        rec.dict[cc[i] - 'a'] = temp;
                    }
                    if(i == cc.length - 1){
                        rec.dict[cc[i] - 'a'].end = true;
                    }
                    rec = rec.dict[cc[i] - 'a'];
                }
            }
        }
        public boolean search(String searchWord) {
            return dfs(searchWord, head, 0, false);
        }

        public boolean dfs(String searchWord, MagicDictionary.dictionaryTree node, int pos, boolean modified) {
            if (pos == searchWord.length()) {
                return modified && node.end;
            }
            int idx = searchWord.charAt(pos) - 'a';
            if (node.dict[idx] != null) {
                if (dfs(searchWord, node.dict[idx], pos + 1, modified)) {
                    return true;
                }
            }
            if (!modified) {
                for (int i = 0; i < 26; ++i) {
                    if (i != idx && node.dict[i] != null) {
                        if (dfs(searchWord, node.dict[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
