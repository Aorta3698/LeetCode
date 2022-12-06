https://leetcode.com/problems/word-subsets/discuss/2352858/Java-or-Preprocess-Words2-First
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        for (String w : words2){
            int[] cur = new int[26];
            for (char ch : w.toCharArray()){
                int v = ch - 'a';
                count[v] = Math.max(count[v], ++cur[v]);
            }
        }
        for (String w : words1){
            int[] cur = new int[26];
            boolean ok = true;
            for (char ch : w.toCharArray()){
                ++cur[ch - 'a'];
            }
            for (int i = 0; i < 26; i++){
                ok &= cur[i] >= count[i];
            }
            if (ok){
                ans.add(w);
            }
        }
        return ans;
    }
}
