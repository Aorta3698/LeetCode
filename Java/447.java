class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++){
                map.merge(dist(points[i], points[j]), 1, Integer::sum);
            }
            for (int d : map.keySet()){
                int dist = map.get(d);
                ans += dist * (dist - 1);
            }
        }

        return ans;
    }

    private int dist(int[] x, int[] y){
        return (int)Math.pow(x[0] - y[0], 2) + (int)Math.pow(x[1] - y[1], 2);
    }
}
