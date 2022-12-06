class MapSum {

    private Trie root;
    private Map<String, Integer> map;
    public MapSum() {
        root = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int prev = map.getOrDefault(key, 0);
        Trie cur = root;
        for (char ch : key.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                cur.nodes[ch - 'a'] = new Trie();
            cur = cur.nodes[ch - 'a'];
            cur.score += val - prev;
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        Trie cur = root;
        for (char ch : prefix.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                return 0;
            cur = cur.nodes[ch - 'a'];
        }

        return cur.score;
    }

    private class Trie{
        Trie[] nodes;
        int score = 0;

        Trie(){
            nodes = new Trie[26];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
