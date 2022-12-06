class Solution {
    public int maxPower(String s) {
        int ans = 1;
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                count++;
                continue;
            }
            ans = Math.max(count, ans);
            count = 1;
        }

        return Math.max(count, ans);
    }
}
