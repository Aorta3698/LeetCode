https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/1725076/Java-Trie-and-DFS-34ms-99.78
class WordDictionary {

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        for (char ch : word.toCharArray()){
            int p = ch - 'a';
            if (cur.nodes[p] == null){
                cur.nodes[p] = new Trie();
            }
            cur.lo = Math.min(p, cur.lo);
            cur.hi = Math.max(p, cur.hi);
            cur = cur.nodes[p];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, Trie cur, int idx){
        if (cur == null) return false;
        if (idx == word.length()) return cur.isWord;
        if (word.charAt(idx) != '.') return dfs(word, cur.nodes[word.charAt(idx) - 'a'], ++idx);
        for (int i = cur.lo; i <= cur.hi; i++){
            if (dfs(word, cur.nodes[i], idx + 1))
                return true;
        }
        return false;
    }

    private class Trie{
        Trie[] nodes;
        boolean isWord;
        int lo = 26, hi = 0;

        Trie(){
            nodes = new Trie[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
