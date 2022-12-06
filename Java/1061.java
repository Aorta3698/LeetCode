class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++)
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');

        uf.update();
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray())
            sb.append((char)(uf.find(ch - 'a') + 'a'));

        return sb.toString();
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;

        UnionFind(){
            nums = IntStream.range(0, 26).toArray();
            ranks= new int[26];
        }

        int find(int p){
            if (nums[p] != p) nums[p] = find(nums[p]);
            return nums[p];
        }

        void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            if (ranks[pRoot] > ranks[qRoot])
                nums[qRoot] = pRoot;
            else if (ranks[pRoot] < ranks[qRoot])
                nums[pRoot] = qRoot;
            else{
                nums[pRoot] = qRoot;
                ranks[qRoot]++;
            }
        }

        void update(){
            for (int i = 0; i < 26; i++)
                if (find(i) > i)
                    nums[find(i)] = nums[i] = i;
        }
    }
    // private class UnionFind{
    //     int[] nums;
    //     int[] ranks;
    //     int[] min;

    //     UnionFind(){
    //         nums = IntStream.range(0, 26).toArray();
    //         ranks= new int[26];
    //         min = new int[26];
    //         Arrays.fill(min, 27);
    //     }

    //     int find(int p){
    //         if (nums[p] != p) nums[p] = find(nums[p]);
    //         return nums[p];
    //     }

    //     void union(int p, int q){
    //         int pRoot = find(p);
    //         int qRoot = find(q);
    //         if (pRoot == qRoot) return;

    //         int one = min[pRoot] == 27? p : min[pRoot];
    //         int two = min[qRoot] == 27? q : min[qRoot];
    //         int root = 0;
    //         if (ranks[pRoot] > ranks[qRoot])
    //             nums[qRoot] = root = pRoot;
    //         else if (ranks[pRoot] < ranks[qRoot])
    //             nums[pRoot] = root = qRoot;
    //         else{
    //             nums[pRoot] = root = qRoot;
    //             ranks[qRoot]++;
    //         }

    //         min[root] = Math.min(one, two);
    //     }

    //     char get(int n){
    //         return (char)('a' + Math.min(n, min[find(n)]));
    //     }
    // }
}
