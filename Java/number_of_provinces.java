class Solution {
    public int findCircleNum(int[][] isConnected) {
        Union union = new Union(isConnected.length);
        for (int i = 0; i < isConnected.length; i++){
            for (int j = i + 1; j < isConnected.length; j++){
                if (isConnected[i][j] == 1)
                    union.union(i, j);
            }
        }

        return union.getGroup();
    }

    private class Union{
        int[] items;
        int[] ranks;
        int group;

        Union(int size){
            group = size;
            items = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; i++)
                items[i] = i;
        }

        private int find(int n){
            if (items[n] == n)
                return n;

            int p = find(items[n]);
            items[n] = p;
            return p;
        }

        private void union(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return;
            group--;

            if (ranks[i] < ranks[j])
                items[iRoot] = jRoot;
            else if (ranks[i] > ranks[j])
                items[jRoot] = iRoot;
            else{
                items[iRoot] = jRoot;
                ranks[j]++;
            }
        }

        private boolean connected(int i, int j){
            return find(i) == find(j);
        }

        private int getGroup(){
            return group;
        }
    }
}
