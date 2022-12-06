https://leetcode.com/problems/number-of-matching-subsequences/discuss/2307443/Jump-Array-or-Java-or-O(26N-%2B-M*M_LEN)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<int[]>[] list = new ArrayList[26];
        Arrays.setAll(list, o -> new ArrayList<>());
        for (int i = 0; i < words.length; i++){
            list[words[i].charAt(0) - 'a'].add(new int[]{0, i});
        }

        int ans = 0;
        for (char ch : s.toCharArray()){
            List<int[]> cur = list[ch - 'a'];
            list[ch - 'a'] = new ArrayList<>();
            for (int[] each : cur){
                if (++each[0] == words[each[1]].length()){
                    ans++;
                }else{
                    list[words[each[1]].charAt(each[0]) - 'a'].add(each);
                }
            }
        }

        return ans;
    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int[][] pos = new int[26][s.length()];
        for (int i = 0; i < 26; i++){
            for (int j = s.length()-1; j >= 0; --j){
                pos[i][j]=s.charAt(j)-'a'==i? j : (j == s.length()-1? -2 : pos[i][j+1]);
            }
        }
        int ans = 0;
        for (String w : words){
            int cur = 0, i = 0;
            for (; i < w.length() && cur >= 0 && cur < s.length(); i++){
                cur = pos[w.charAt(i)-'a'][cur]+1;
            }
            if (i == w.length() && cur >= 0){
                ans++;
            }
        }
        return ans;
    }
}
