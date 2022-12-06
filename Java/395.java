https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/1856449/Java-or-Share-my-O(n)-solution-or-2ms
class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0, lo = 0, hi = 26;
        boolean[] seen = new boolean[27];

        while (lo < hi){
            int mid = (lo + hi + 1) >> 1;
            int ret = find(s, k, mid);
            ans = Math.max(ans, ret);
            seen[mid] = true;
            if (ret > 0) lo = mid;
            else hi = mid - 1;
        }

        for (int i = 1; i <= lo; i++){
            if (!seen[i]){
                ans = Math.max(find(s, k, i), ans);
            }
        }

        return ans;
    }

    private int find(String s, int k, int guess){
        int[] count = new int[26];
        int uniq = 0, max = 0, valid = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            int x = s.charAt(i) - 'a';
            if (++count[x] == 1){
                ++uniq;
            }
            if (count[x] == k){
                ++valid;
            }
            while(uniq > guess){
                int y = s.charAt(j++) - 'a';
                if (count[y] == k){
                    --valid;
                }
                if (--count[y] == 0){
                    --uniq;
                }
            }
            if (valid == uniq){
                max = Math.max(i - j + 1, max);
            }
        }

        return max;
    }
}
