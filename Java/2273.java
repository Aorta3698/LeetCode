class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] prev = new int[26];
        for (String w : words){
            int[] cur = new int[26];
            for (char ch : w.toCharArray()){
                cur[ch - 'a']++;
            }
            if (!Arrays.equals(prev, cur)){
                prev = cur;
                ans.add(w);
            }
        }
        return ans;
    }
}
