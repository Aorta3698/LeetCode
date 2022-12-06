class Solution {
    public String getPermutation(int n, int k) {
        boolean[] seen = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++){
            fact[i] = i * fact[i - 1];
        }

        while(sb.length() < n){
            int j = n - 1 - sb.length(), pick;
            int d = (k - 1) / fact[j];
            k -= d * fact[j];
            for (pick = 1; ; ++pick){
                if (!seen[pick] && d-- == 0)
                    break;
            }
            sb.append(pick);
            seen[pick] = true;
        }

        return sb.toString();
    }
}
