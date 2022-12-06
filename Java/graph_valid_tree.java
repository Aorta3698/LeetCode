class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges)
            if(!uf.unite(e[0], e[1]))
                return false;

        return uf.getCount() == 1;
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;
        int count;

        UnionFind(int size){
            count = size;
            nums = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; i++)
                nums[i] = i;
        }

        private int find(int n){
            if (nums[n] == n) return n;
            nums[n] = find(nums[n]);
            return nums[n];
        }

        private boolean unite(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return false;

            if (ranks[iRoot] < ranks[jRoot])
                nums[iRoot] = jRoot;
            else if (ranks[iRoot] > ranks[jRoot])
                nums[jRoot] = iRoot;
            else{
                nums[iRoot] = jRoot;
                ranks[jRoot]++;
            }

            count--;
            return true;
        }

        private int getCount(){
            return count;
        }
    }
}
