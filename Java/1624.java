class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'a';
            if (idx[cur] != -1) ans = Math.max(i - idx[cur] - 1, ans);
            if (idx[cur] == -1) idx[cur] = i;
        }

        return ans;
    }
}
