https://leetcode.com/problems/walking-robot-simulation/discuss/1995593/Obstacle-at-(0-0)-or-A-binary-Search-Generalized-Sol-Java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int[] o : obstacles){
            xMap.computeIfAbsent(o[0], t -> new ArrayList<>()).add(o[1]);
            yMap.computeIfAbsent(o[1], t -> new ArrayList<>()).add(o[0]);
        }
        for (int x : xMap.keySet()){
            Collections.sort(xMap.get(x));
        }
        for (int y : yMap.keySet()){
            Collections.sort(yMap.get(y));
        }
        int ans = 0, d = 0;
        int[] p = new int[2]; // y, x
        for (int c : commands){
            if (c == -1){
                d = (d + 1) % 4;
            }else if (c == -2){
                d = (d + 3) % 4;
            }else{
                List<Integer> cur = d == 0 || d == 2?
                    xMap.getOrDefault(p[1], List.of()) : yMap.getOrDefault(p[0], List.of());

                int lo = 0, hi = cur.size(), stupid = d >= 2? -1 : 0;
                while(lo < hi){
                    int mid = (lo + hi) >> 1;
                    if (cur.get(mid) > p[d%2] + stupid)
                        hi = mid;
                    else
                        lo = mid + 1;
                }
                if (d >= 2){
                    lo--;
                }
                if (lo == cur.size() || lo == -1){
                    p[d % 2] += c*(d < 2? 1 : -1);
                }else if (d < 2){
                    p[d % 2] = Math.min(p[d%2]+c, cur.get(lo)-1);
                }else{
                    p[d % 2] = Math.max(p[d%2]-c, cur.get(lo)+1);
                }

                ans = Math.max(ans, p[0]*p[0]+p[1]*p[1]);
            }
        }
        return ans;
    }
}
