class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[][] pre = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++){
            pre[i] = pre[i - 1].clone();
            pre[i][s.charAt(i - 1) - 'a']++;
        }
        for (int[] q : queries){
            int odd = -1;
            for (int i = 0; i < 26; i++){
                if ((pre[q[1] + 1][i] - pre[q[0]][i]) % 2 != 0){
                    odd++;
                }
            }
            ans.add(2 * q[2] >= odd);
        }

        return ans;
    }
}
