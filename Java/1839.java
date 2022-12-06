class Solution {
    public int longestBeautifulSubstring(String word) {
        int[] count = new int[5];
        String all = "aeiou";
        int ans = 0, uniq = 0;

        for (int i = 0, j = 0; i < word.length(); i++){
            if (i > 0 && word.charAt(i) < word.charAt(i - 1)){
                j = i;
                count = new int[5];
                uniq = 0;
            }
            if (++count[all.indexOf(word.charAt(i))] == 1){
                ++uniq;
            }
            if (uniq == 5){
                ans = Math.max(ans, i - j + 1);
            }
        }

        return ans;
    }
}
