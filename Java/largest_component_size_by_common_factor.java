class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int i : nums) max = Math.max(i, max);

        HashMap<Integer, Integer> numToPrime = new HashMap<>();
        UnionFind uf = new UnionFind(max+1);
        for (int n : nums) unionPrimes(n, uf, numToPrime);

        int ans = 0;
        HashMap<Integer, Integer> group = new HashMap<>();
        for (int n : nums){
            int id = uf.find(numToPrime.get(n));
            group.merge(id, 1, Integer::sum);
            ans = Math.max(group.get(id), ans);
        }

        return ans;
    }

    private void unionPrimes(int n, UnionFind uf, HashMap<Integer, Integer> numToPrime){
        int copy = n;
        int prev = -1;
        for (int i = 2; n >= i*i; i++){
            if (n % i != 0) continue;
            if (prev != -1) uf.union(prev, i);
            prev = i;
            n /= i;
            i--;
        }

        if(prev != -1) uf.union(n, prev);
        numToPrime.put(copy, n);
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int r){
            if (r != nums[r]) nums[r] = find(nums[r]);
            return nums[r];
        }

        private void union(int i, int j){
            i = find(i);
            j = find(j);
            if (i == j) return;
            if (ranks[i] > ranks[j])
                nums[j] = i;
            else if (ranks[i] < ranks[j])
                nums[i] = j;
            else{
                nums[j] = i;
                ranks[i]++;
            }
        }
    }
}
