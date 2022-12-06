class Solution {
    int n;
    public int movesToChessboard(int[][] grid) {
        n = grid.length;
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                cnt += grid[i][j] == 1? 1 : -1;
            }
        }
        if (cnt != 0 && n % 2 == 0 || Math.abs(cnt)>1 && n % 2 == 1){
            return -1;
        }
        int a = solve(grid);
        int b = solve(rotate(grid));
        return a == -1 || b == -1? -1 : a+b;
    }

    private int[][] rotate(int[][] grid){
        int[][] ng = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                ng[i][j] = grid[j][n-1-i];
            }
        }
        return ng;
    }

    private int solve(int[][] grid){
        int[] arr = new int[n];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    arr[i]|=1<<j;
                }
            }
            seen.add(arr[i]);
        }
        if (seen.size()!=2){
            return -1;
        }
        Map<Integer, Integer>[] map = new HashMap[2];
        Arrays.setAll(map, o -> new HashMap<>());
        for (int i = 0; i < n; i++){
            map[i%2].merge(arr[i], 1, Integer::sum);
        }
        int even = map[0].getOrDefault(arr[0], 0);
        int odd  = map[1].getOrDefault(arr[0], 0);
        int cnt = even+odd;
        if (n % 2 == 0 && cnt != n/2 ||  n % 2 == 1 && Math.abs(2*cnt-n) > 1){
            return -1;
        }else if (n % 2 == 0){
            return Math.min(n/2-even, n/2-odd);
        }else{
            return 2*cnt>n? (n+1)/2-even : n/2-odd;
        }
    }
}
