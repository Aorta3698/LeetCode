https://leetcode.com/problems/search-suggestions-system/discuss/1684619/Java-Easy-Trie-Implementation
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie root = new Trie();
        Arrays.sort(products);

        int i = 0;
        for (String s : products){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch - 'a'] == null)
                    cur.nodes[ch - 'a'] = new Trie();
                cur = cur.nodes[ch - 'a'];
                if (cur.words.size() < 3) cur.words.add(i);
            }
            i++;
        }

        Trie cur = root;
        for (char ch : searchWord.toCharArray()){
            List<String> list = new ArrayList<>();
            if (cur != null) cur = cur.nodes[ch - 'a'];
            for (int j = 0; cur != null && j < cur.words.size(); j++)
                list.add(products[cur.words.get(j)]);
            ans.add(list);
        }

        return ans;
    }

    private class Trie{
        Trie[] nodes;
        List<Integer> words;

        Trie(){
            nodes = new Trie[26];
            words = new ArrayList<>();
        }
    }
}
