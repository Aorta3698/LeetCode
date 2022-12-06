class Solution {
    int INF = (int)1e9, mxR = -INF, mnR = INF, mxC = -INF, mnC = INF;
    int[] dx = new int[]{0, 0, 2, 2};
    int[] dy = new int[]{1, 3, 1, 3};
    public boolean isRectangleCover(int[][] rectangles) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int total = 0, area = 0;
        for (int[] r : rectangles){
            for (int d = 0; d < 4; d++){
                int a = r[dx[d]], b = r[dy[d]];
                map.computeIfAbsent(a, o -> new HashMap<>()).merge(b, 1, Integer::sum);
            }
            mxR = Math.max(mxR, Math.max(r[0], r[2]));
            mnR = Math.min(mnR, Math.min(r[0], r[2]));
            mxC = Math.max(mxC, Math.max(r[1], r[3]));
            mnC = Math.min(mnC, Math.min(r[1], r[3]));
            area += (r[2]-r[0])*(r[3]-r[1]);
        }
        for (int x : map.keySet()){
            for (int y : map.get(x).keySet()){
                if (map.get(x).get(y)%2 == 1 && (++total > 4 || !isCorner(x, y))){
                    return false;
                }
            }
        }
        return total == 4 && area == (mxR-mnR) * (mxC-mnC);
    }

    private boolean isCorner(int x, int y){
        return x == mxR && y == mxC
            || x == mxR && y == mnC
            || x == mnR && y == mxC
            || x == mnR && y == mnC;
    }
}
