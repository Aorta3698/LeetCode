class Solution {
    public int[][] buildMatrix(int k, int[][] R, int[][] C) {
        int[][] ans = new int[k][k];
        int[] yp = new int[k+1];
        int[] xp = new int[k+1];
        Arrays.fill(xp, -1);
        Arrays.fill(yp, -1);
        if (!build(R, xp, k) || !build(C, yp, k)){
            return new int[0][0];
        }
        for (int i = 1; i <= k; i++){
            ans[xp[i]][yp[i]] = i;
        }
        return ans;
    }

    private boolean build(int[][] A, int[] pos, int k){
        List<Integer>[] map = new ArrayList[k+1];
        Arrays.setAll(map, o -> new ArrayList<>());
        int[] indg = new int[k+1];
        int depth = 0;
        for (int[] a : A){
            map[a[0]].add(a[1]);
            indg[a[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>(IntStream.range(1, k+1).filter(o -> indg[o] == 0).boxed().toList());
        while(!queue.isEmpty()){
            int y = queue.poll();
            pos[y] = depth++;
            for (int next : map[y]){
                if (--indg[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if (Arrays.stream(indg).anyMatch(o -> o > 0)){
            return false;
        }
        for (int i = 1, hi = k; i <= k; i++){
            if (pos[i] == -1){
                pos[i] = --hi;
            }
        }
        return true;
    }
}
