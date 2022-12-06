class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (char ch : target.toCharArray()){
            count[ch - 'a']++;
        }
        int[] scount = new int[26];
        for (char ch : s.toCharArray()){
            scount[ch - 'a']++;
        }
        int ans = 100000000;
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                ans = Math.min(ans, scount[i]/count[i]);
            }
        }
        return ans;
    }
}
