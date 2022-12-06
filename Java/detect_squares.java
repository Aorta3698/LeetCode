class DetectSquares {

    private HashMap<Integer, HashSet<Integer>> rowMap;
    private HashMap<Integer, HashSet<Integer>> colMap;
    private HashMap<Integer, Integer> pointMap;

    public DetectSquares() {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        pointMap = new HashMap<>();
    }

    public void add(int[] point) {
        rowMap.computeIfAbsent(point[0], o -> new HashSet<>()).add(point[1]);
        colMap.computeIfAbsent(point[1], o -> new HashSet<>()).add(point[0]);
        pointMap.merge(mask(point[0], point[1]), 1, Integer::sum);
    }

    public int count(int[] point) {
        if (!rowMap.containsKey(point[0]) || !colMap.containsKey(point[1]))
            return 0;

        int ans = 0;

        for (int col : rowMap.get(point[0])){
            if (col == point[1]) continue;

            for (int row : colMap.get(point[1])){
                if (row == point[0] || (Math.abs(point[1] - col) != Math.abs(point[0] - row)))
                    continue;

                if (pointMap.containsKey(mask(row, col)))
                    ans += pointMap.get(mask(point[0], col))
                        * pointMap.get(mask(row, point[1]))
                        * pointMap.get(mask(row, col));
            }
        }

        return ans;
    }

    private int mask(int r, int c){
        return r * 1001 + c;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
