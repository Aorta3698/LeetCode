class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, List<Integer>> xMap = new HashMap<>();
        HashMap<Integer, List<Integer>> yMap = new HashMap<>();
        HashSet<Integer> pointSet = new HashSet<>();
        for (int[] p : points){
            xMap.computeIfAbsent(p[0], o -> new ArrayList<>()).add(p[1]);
            yMap.computeIfAbsent(p[1], o -> new ArrayList<>()).add(p[0]);
            pointSet.add(mask(p[0], p[1]));
        }

        int ans = Integer.MAX_VALUE;
        for (int[] p : points){
            for (int y : xMap.get(p[0])){
                if (y == p[1]) continue;
                for (int x : yMap.get(p[1])){
                    if (x == p[0] || !pointSet.contains(mask(x, y))) continue;
                    ans = Math.min(ans, Math.abs(p[0] - x) * Math.abs(p[1] - y));
                }
            }
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }

    private int mask(int x, int y){
        return 40001 * x + y;
    }
}
