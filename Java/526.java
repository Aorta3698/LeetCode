class Solution {
    public int countArrangement(int n) {
        return find(n, 1, 0, new Integer[1 << (n + 1)]);
    }

    private static int find(int n, int idx, int key, Integer[] memo){
        if (n+1 == idx) return 1;
        if (memo[key] != null) return memo[key];

        int sum = 0;
        for (int i = 1; i <= n; i++){
            if ((key & (1 << i)) == 0 && (i % idx == 0 || idx % i == 0)){
                sum += find(n, idx + 1, key | (1 << i), memo);
            }
        }

        return memo[key] = sum;
    }
}
