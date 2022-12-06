class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++){
            int l = leftChild[i];
            int r = rightChild[i];
            if (l != -1 && !uf.unite(i, l)) return false;
            if (r != -1 && !uf.unite(i, r)) return false;
        }

        return uf.getCount() == 1;
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;
        int count;

        UnionFind(int size){
            count = size;
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int p){
            if (p == nums[p]) return p;
            nums[p] = find(nums[p]);
            return nums[p];
        }

        //let a = parent, b = child
        //can't use union by rank.
        private boolean unite(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot || b != bRoot) return false;
            count--;
            if (ranks[aRoot] > ranks[bRoot])
                nums[bRoot] = aRoot;
            // else if (ranks[aRoot] < ranks[bRoot])
            //     nums[aRoot] = bRoot;
            else{
                nums[bRoot] = aRoot;
                ranks[aRoot]++;
            }

            return true;
        }

        private int getCount(){
            return count;
        }
    }
}
