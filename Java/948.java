class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0, j = tokens.length - 1, ans = 0;
        Arrays.sort(tokens);
        int[] pre = new int[tokens.length + 1];
        for (int k = 0; k < tokens.length; k++){
            pre[k + 1] = pre[k] + tokens[k];
        }

        while(i <= j && power >= tokens[i]){
            int lo = i - 1, hi = j;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                int take = pre[mid + 1] - pre[i];
                if (power >= take)
                    lo = mid;
                else
                    hi = mid - 1;
            }
            ans = Math.max(ans, lo - i + 1);
            power += tokens[j--] - tokens[i++];
        }

        return ans;
    }
}
