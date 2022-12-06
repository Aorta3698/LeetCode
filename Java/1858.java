class Solution {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        Arrays.sort(words, Comparator.comparingInt(o -> o.length()));
        String ans = "";
        for (String w : words){
            Trie cur = root;
            String cand = w;
            int idx = 0;
            for (char ch : w.toCharArray()){
                if (cur.nodes[ch - 'a'] == null){
                    cur.nodes[ch - 'a'] = new Trie();
                }
                cur = cur.nodes[ch - 'a'];
                if (++idx < w.length() && !cur.isWord) cand = "";
            }
            cur.isWord = true;
            if (cand.length() > ans.length()) ans = cand;
            if (cand.length() == ans.length() && ans.compareTo(cand) > 0) ans = cand;
        }

        return ans;
    }

    private class Trie{
        boolean isWord;
        Trie[] nodes;

        Trie(){
            nodes = new Trie[26];
        }
    }
}
