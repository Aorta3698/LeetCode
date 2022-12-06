https://leetcode.com/problems/concatenated-words/discuss/2240108/Java-or-Trie-and-Sort-or-91ms
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Trie root = new Trie();
        Arrays.sort(words, Comparator.comparingInt(o->o.length()));
        for (String s : words){
            if (dfs(0,s,root,root)){
                ans.add(s);
            }
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch-'a']==null){
                    cur.nodes[ch-'a']=new Trie();
                }
                cur=cur.nodes[ch-'a'];
            }
            cur.isWord=true;
        }
        return ans;
    }

    private boolean dfs(int idx, String s, Trie cur, Trie root){
        if (cur==null){
            return false;
        }
        if (idx==s.length()){
            return cur.isWord;
        }
        return cur.isWord && dfs(idx,s,root,root)||dfs(idx+1,s,cur.nodes[s.charAt(idx)-'a'],root);
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        boolean isWord;
        Trie(){}
    }
}
