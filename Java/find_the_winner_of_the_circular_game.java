class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] taken = new boolean[n];
        int cur = k - 1;
        for (int i = 0; i < n - 1; i++){
            taken[cur] = true;
            int count = 0;
            while(count < k){
                cur = (cur + 1) % n;
                if (taken[cur]) continue;
                count++;
            }
        }

        for (int i = 0; i < n; i++)
            if (!taken[i])
                return i + 1;

        return -1;
    }
}
