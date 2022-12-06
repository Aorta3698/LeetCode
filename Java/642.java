https://leetcode.com/problems/design-search-autocomplete-system/discuss/1686741/Java-or-Trie-and-List-and-Map-or-100ms-(90)-or-Similar-to-1268.
class AutocompleteSystem {

    private Trie root;
    private Trie tmp;
    private StringBuilder sb;
    private Map<String, Integer> tMap;
    private Comparator<String> cmp;
    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new Trie();
        tMap = new HashMap<>();
        tmp = root;

        cmp = (a, b) -> tMap.get(a) == tMap.get(b)?
            a.compareTo(b) : tMap.get(b) - tMap.get(a);

        int i = 0;
        for (String s : sentences){
            addWord(s, times[i++]);
        }
    }

    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#'){
            addWord(sb.toString(), 1);
            sb.setLength(0);
            tmp = root;
            return ans;
        }

        if (tmp != null) tmp = tmp.nodes[c];

        sb.append(c);
        return tmp == null? List.of() : tmp.top;
    }

    private void addWord(String s, int cnt){
        tMap.merge(s, cnt, Integer::sum);
        Trie cur = root;
        for (char ch : s.toCharArray()){
            if (cur.nodes[ch] == null)
                cur.nodes[ch] = new Trie();
            cur = cur.nodes[ch];
            if (!cur.top.contains(s)) cur.top.add(s);
            Collections.sort(cur.top, cmp);
            if (cur.top.size() > 3) cur.top.remove(3);
        }
    }

    private class Trie{
        Trie[] nodes;
        List<String> top;

        Trie(){
            nodes = new Trie[128];
            top = new ArrayList<>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
