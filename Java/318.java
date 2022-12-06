class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++){
            for (char ch : words[i].toCharArray()){
                count[i] |= (1 << (ch - 'a'));
            }
        }
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if ((count[i] & count[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
