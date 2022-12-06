class MagicDictionary {

    private Trie root;
    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch - 'a'] == null)
                    cur.nodes[ch - 'a'] = new Trie();
                cur = cur.nodes[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        Trie cur = root;
        int idx = 0;
        for (char ch : searchWord.toCharArray()){
            if (cur == null) break;
            for (int i = 0; i < 26; i++){
                if (i == ch - 'a' || cur.nodes[i] == null) continue;
                if (find(searchWord, idx + 1, cur.nodes[i])) return true;
            }
            cur = cur.nodes[ch - 'a'];
            idx++;
        }

        return false;
    }

    private boolean find(String s, int idx, Trie cur){
        if (idx == s.length()) return cur.isWord;
        if (cur.nodes[s.charAt(idx) - 'a'] == null) return false;
        return find(s, idx + 1, cur.nodes[s.charAt(idx) - 'a']);
    }

    private class Trie{
        boolean isWord;
        Trie[] nodes;

        Trie(){
            nodes = new Trie[26];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

// class MagicDictionary {

    // private Set<String> words;
    // private Set<Long> set;
    // private final int p = 31;
    // private final int m = (int)1e9 + 9;

    // public MagicDictionary() {
    //     words = new HashSet<>();
    //     set = new HashSet<>();
    // }

    // public void buildDict(String[] dictionary) {
    //     for (String s : dictionary){
    //         words.add(s);
    //         decompose(s, true);
    //     }
    // }

    // public boolean search(String searchWord) {
    //     int req = words.contains(searchWord)? searchWord.length() : 0;
    //     return decompose(searchWord, false) > req;
    // }

    // private int decompose(String s, boolean mode){
    //     int cnt = 0;
    //     long hash = hash(s), right = 0;
    //     int[] mul = new int[s.length()];
    //     for (int i = s.length() - 1, v = 1; i >= 0; i--){
    //         mul[i] = v;
    //         v *= p;
    //         v %= m;
    //     }

    //     for (int i = s.length() - 1; i >= 0; i--){
    //         int n = s.charAt(i) - 'a' + 1;
    //         long copy = hash - right;
    //         copy -= (n * mul[i]) % m;
    //         copy /= p;
    //         copy += right;
    //         if (mode) set.add(copy);
    //         right *= p;
    //         right += n;
    //         right %= m;
    //         if (!mode && set.contains(copy)) cnt++;
    //     }

    //     return cnt;
    // }

    // private long hash(String s){
    //     long sum = 0;
    //     for (char ch : s.toCharArray()){
    //         sum *= p;
    //         sum += (ch - 'a' + 1);
    //         sum %= m;
    //     }

    //     return sum;
    // }
// }
