class DetectSquares {

    int[][] count = new int[1001][1001];
    Map<Integer, List<int[]>> diag = new HashMap<>();
    Map<Integer, List<int[]>> anti = new HashMap<>();
    public DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        if (++count[x][y] == 1){
            diag.computeIfAbsent(x+y, o -> new ArrayList<>()).add(point);
            anti.computeIfAbsent(x-y, o -> new ArrayList<>()).add(point);
        }
    }

    public int count(int[] point) {
        int ans = 0, x = point[0], y = point[1];
        for (int[] p : diag.getOrDefault(x+y, List.of())) if (p[0] != x || p[1] != y){
            int nx = p[0], ny = p[1];
            ans += count[nx][ny] * count[x][ny] * count[nx][y];
        }
        for (int[] p : anti.getOrDefault(x-y, List.of())) if (p[0] != x || p[1] != y){
            int nx = p[0], ny = p[1];
            ans += count[nx][ny] * count[x][ny] * count[nx][y];
        }
        return ans;
    }
}
