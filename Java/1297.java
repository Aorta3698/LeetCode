class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        int i = minSize;
        int uniq = 0;
        int[] count = new int[26];
        for (int j = 0; j < i; j++){
            if (++count[s.charAt(j) - 'a'] == 1){
                ++uniq;
            }
        }
        for (int j = i; j <= s.length(); j++){
            if (uniq <= maxLetters){
                ans = Math.max(ans, map.merge(s.substring(j - i, j), 1, Integer::sum));
            }
            if (j == s.length()){
                break;
            }
            if (--count[s.charAt(j - i) - 'a'] == 0){
                --uniq;
            }
            if (++count[s.charAt(j) - 'a'] == 1){
                ++uniq;
            }
        }

        return ans;
    }
}
