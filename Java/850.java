https://leetcode.com/problems/rectangle-area-ii/discuss/2443714/Java-or-Clean-and-Concise-or-Line-Sweep-or-The-Skyline-Problem-or-Commented
class Solution {
    public int rectangleArea(int[][] A) {
        int ans = 0, L = 1, R = -1, height = 0, px = 0, M = (int)1e9+7;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        TreeMap<Integer, Integer> ymap = new TreeMap<>();
        for (int i = 0; i < A.length; i++){
            map.computeIfAbsent(A[i][0], o -> new ArrayList<>()).add(new int[]{i, L});
            map.computeIfAbsent(A[i][2], o -> new ArrayList<>()).add(new int[]{i, R});
        }
        for (int x : map.keySet()){
            int py = 0, cnt = 0, sum = 0;
            for (int y : ymap.keySet()){
                if (cnt > 0){
                    sum += y - py;
                }
                py = y;
                cnt += ymap.get(y);
            }
            ans += 1L * (x - px) * sum % M;
            ans %= M;
            px = x;
            for (int[] m : map.get(x)){
                if (ymap.merge(A[m[0]][1], 1*m[1], Integer::sum) == 0){
                    ymap.remove(A[m[0]][1]);
                }
                if (ymap.merge(A[m[0]][3], -1*m[1], Integer::sum) == 0){
                    ymap.remove(A[m[0]][3]);
                }
            }
        }
        return ans;
    }
}
