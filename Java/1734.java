class Solution {
    public int[] decode(int[] encoded) {
        int all = 0;
        for (int i = 0; i <= encoded.length + 1; i++){
            all ^= i;
        }
        for (int i = 0, cur = 0; i < encoded.length; i++){
            cur ^= encoded[i];
            encoded[i] = cur;
        }
        for (int i = 0; i < encoded.length; i++){
            all ^= encoded[i];
        }
        int[] ans = new int[encoded.length + 1];
        ans[0] = all;
        for (int i = 1; i < ans.length; i++){
            ans[i] = encoded[i - 1] ^ ans[0];
        }

        return ans;
    }
}
