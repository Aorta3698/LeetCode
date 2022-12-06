https://leetcode.com/problems/unique-length-3-palindromic-subsequences/discuss/1871535/Java-O(2N)-98-Speed
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = s.length() - 1; i >= 0; i--){
            if (last[s.charAt(i) - 'a'] == -1){
                last[s.charAt(i) - 'a'] = i;
            }
        }

        int ans = 0;
        int[] count = new int[26];
        Map<Integer, int[]> first = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'a';
            if (last[cur] - i <= 1 && !first.containsKey(cur)){
                last[cur] = -1;
            }
            if (last[cur] == i){
                int[] oldCount = first.get(cur);
                for (int j = 0; j < 26; j++){
                    if (count[j] - oldCount[j] > 0){
                        ans++;
                    }
                }
            }
            count[cur]++;
            if (last[cur] > -1 && !first.containsKey(cur)){
                first.put(cur, count.clone());
            }
        }

        return ans;
    }
}
