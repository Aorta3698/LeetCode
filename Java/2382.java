https://leetcode.com/problems/maximum-segment-sum-after-removals/discuss/2455691/LeetCode-1970-and-803
class Solution {
    int[] A;
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        A = nums;
        UF uf = new UF(nums.length);
        long[] ans = new long[removeQueries.length];
        for (int i = ans.length-1; i >= 0; i--){
            ans[i] = uf.max;
            int j = removeQueries[i];
            uf.union(j, j+1);
            uf.union(j, j-1);
        }
        return ans;
    }

    private class UF{
        int[] rank;
        int[] parent;
        long[] weight;
        long max = 0;

        UF (int n){
            rank = new int[n];
            weight = new long[n];
            parent = IntStream.range(0, n).toArray();
        }

        int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }

        void union(int x, int y){
            weight[x] = A[x];
            max = Math.max(A[x], max);
            if (y < 0 || y == rank.length){
                return;
            }
            x = find(x); y = find(y);
            if (x == y || weight[y] == 0){
                return;
            }
            if (rank[x] > rank[y]){
                parent[y] = x;
                weight[x] += weight[y];
            }else{
                parent[x] = y;
                weight[y] += weight[x];
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
            max = Math.max(max, weight[x]);
            max = Math.max(max, weight[y]);
        }
    }
}
