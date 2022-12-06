class Solution {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int[] log : logs){
            uf.unite(log[1], log[2]);
            if (uf.getCount() == 1) return log[0];
        }

        return -1;
    }

    private class UnionFind{
        int[] friends;
        int[] ranks;
        int count;

        UnionFind(int size){
            friends = IntStream.range(0, size).toArray();
            ranks = new int[size];
            count = size;
        }

        private int find(int q){
            if (friends[q] == q) return q;
            friends[q] = find(friends[q]);
            return friends[q];
        }

        private void unite(int i, int j){
            int iR = find(i);
            int jR = find(j);
            if (iR == jR) return;
            count--;

            if (ranks[iR] < ranks[jR])
                friends[iR] = jR;
            else if (ranks[iR] > ranks[jR])
                friends[jR] = iR;
            else{
                friends[iR] = jR;
                ranks[jR]++;
            }
        }

        private int getCount(){
            return count;
        }
    }
}
