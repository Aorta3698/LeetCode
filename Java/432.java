class AllOne {

    Trie root;
    TreeMap<Integer, Set<String>> map;
    public AllOne() {
        root = new Trie();
        map = new TreeMap<>();
    }

    public void inc(String key) {
        int count = update(key, 1);
        remove(key, count - 1);
        map.computeIfAbsent(count, o -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        int count = update(key, -1);
        remove(key, count + 1);
        if (count > 0){
            map.computeIfAbsent(count, o -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        return map.isEmpty()? "" : map.get(map.lastKey()).iterator().next();
    }

    public String getMinKey() {
        return map.isEmpty()? "" : map.get(map.firstKey()).iterator().next();
    }

    private int update(String key, int add){
        Trie cur = root;
        for (char ch : key.toCharArray()){
            if (cur.nodes[ch - 'a'] == null){
                cur.nodes[ch - 'a'] = new Trie();
            }
            cur = cur.nodes[ch - 'a'];
        }
        cur.count += add;
        return cur.count;
    }

    private void remove(String key, int count){
        Set<String> set = map.get(count);
        if (set != null){
            if (set.size() == 1){
                map.remove(count);
            }else{
                set.remove(key);
            }
        }
    }

    private class Trie{
        Trie[] nodes = new Trie[26];
        int count = 0;
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
