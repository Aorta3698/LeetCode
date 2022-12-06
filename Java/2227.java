class Encrypter {

    int[] key;
    char[] keys;
    Map<String, List<Integer>> map;
    String[] values;
    Trie root;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = keys;
        key = new int[26];
        for (int i = 0; i < keys.length; i++){
            key[keys[i] - 'a'] = i;
        }

        this.values = values;
        map = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            map.computeIfAbsent(values[i], o -> new ArrayList<>()).add(i);
        }

        root = new Trie();
        for (String d : dictionary){
            Trie cur = root;
            for (char ch : d.toCharArray()){
                if (cur.nodes[ch - 'a'] == null){
                    cur.nodes[ch - 'a'] = new Trie();
                }
                cur = cur.nodes[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word1.toCharArray()){
            sb.append(values[key[ch - 'a']]);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return dfs(word2, 0, root);
    }

    private int dfs(String s, int idx, Trie cur){
        if (idx == s.length()){
            return cur.isWord? 1 : 0;
        }

        String m = s.substring(idx, idx + 2);

        int ans = 0;
        for (int next : map.getOrDefault(m, List.of())){
            if (cur.nodes[keys[next] - 'a'] == null){
                continue;
            }
            ans += dfs(s, idx + 2, cur.nodes[keys[next] - 'a']);
        }

        return ans;
    }

    private class Trie{
        Trie[] nodes = new Trie[26];
        boolean isWord;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
