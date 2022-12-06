class Solution {
    public int maxVowels(String s, int k) {
        String all = "aeiou";
        int count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (all.indexOf(s.charAt(i)) >= 0){
                count++;
            }
            if (i >= k && all.indexOf(s.charAt(i - k)) >= 0){
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
