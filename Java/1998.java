https://leetcode.com/problems/gcd-sort-of-an-array/discuss/2466210/Java-or-Union-Find-with-Sieve-or-92ms
class Solution {
    public boolean gcdSort(int[] nums) {
        int[] A = nums.clone();
        Arrays.sort(A);
        int N = A[A.length-1];
        UF uf = new UF(N+1);
        boolean[] present = new boolean[N+1];
        for (int n : A){
            present[n] = true;
        }
        for (int i = 2; i <= N; i++){
            for (int j = i, prev=-1; j <= N; j+=i){
                if (present[j]){
                    uf.union(prev, j);
                    prev = j;
                }
            }
        }
        for (int i = 0; i < A.length; i++){
            if (uf.find(A[i]) != uf.find(nums[i])){
                return false;
            }
        }
        return true;
    }

    private class UF {
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
        }
        int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }
        void union(int x, int y){
            if (x < 0 || y < 0){
                return;
            }
            x = find(x); y = find(y);
            if (x == y){
                return;
            }
            if (rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }
    }
}
