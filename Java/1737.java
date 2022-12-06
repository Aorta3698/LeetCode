class Solution {
    public int minCharacters(String a, String b) {
        int[] one = new int[26];
        int[] two = new int[26];
        for (char ch : a.toCharArray()){
            one[ch - 'a']++;
        }
        for (char ch : b.toCharArray()){
            two[ch - 'a']++;
        }

        int ans = (int)1e9, n = a.length(), m = b.length();
        for (int i = 0; i < 26; i++){
            ans = Math.min(m + n - one[i] - two[i], ans);
            if (i > 0){
                one[i] += one[i - 1];
                two[i] += two[i - 1];
            }
            if (i < 25){
                ans = Math.min(ans, n - one[i] + two[i]);
                ans = Math.min(ans, m - two[i] + one[i]);
            }
        }

        return ans;
    }
}
