class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<>(List.of(1, 1));
        int next = 2;
        while(next <= k) {
            f.add(next);
            next = f.get(f.size() - 1) + f.get(f.size() - 2);
        }

        int ans = 0, prev = f.size() - 1;
        while(k > 0){
            int i = prev;
            for (; f.get(i) > k; i--);
            k -= f.get(i);
            prev = i;
            ans++;
        }

        return ans;
    }
}
