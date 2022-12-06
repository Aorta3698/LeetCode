class Solution {
    public int beautySum(String s) {
        int[][] count = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++){
            count[i] = count[i - 1].clone();
            count[i][s.charAt(i - 1) - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length(); j++){
                int min = 1000;
                int max = 0;
                for (int k = 0; k < 26; k++){
                    int diff = count[j + 1][k] - count[i][k];
                    if (diff == 0){
                        continue;
                    }
                    max = Math.max(diff, max);
                    min = Math.min(diff, min);
                }
                if (max > 0 && min < 1000){
                    ans += max - min;
                }
            }
        }

        return ans;
    }
}
