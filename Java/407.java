https://leetcode.com/problems/trapping-rain-water-ii/discuss/2220234/Java-or-DFS-from-walls
class Solution {
    int m;
    int n;
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int trapRainWater(int[][] heightMap) {
        m = heightMap.length;
        n = heightMap[0].length;
        int ans = 0;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o->heightMap[o[0]][o[1]]));
        for (int i = 0; i < m; i++){
            minheap.offer(new int[]{i, 0});
            minheap.offer(new int[]{i, n-1});
        }
        for (int i = 0; i < n; i++){
            minheap.offer(new int[]{0, i});
            minheap.offer(new int[]{m-1,i});
        }
        while(!minheap.isEmpty()){
            int[] top = minheap.poll();
            ans += fill(top[0], top[1], heightMap[top[0]][top[1]], heightMap, minheap);
        }
        return ans;
    }

    private int fill(int i, int j, int lvl, int[][] heightMap, PriorityQueue<int[]> minheap){
        if (i<0||j<0||i==m||j==n||heightMap[i][j]==-1){
            return 0;
        }
        if (heightMap[i][j]>lvl){
            minheap.offer(new int[]{i, j});
            return 0;
        }
        int ans = lvl-heightMap[i][j];
        heightMap[i][j]=-1;
        for (int k=0;k<4;k++){
            ans+=fill(i+dx[k],j+dy[k],lvl,heightMap,minheap);
        }
        return ans;
    }

// [[14,17,18,16,14,16],
// [17,3,10,2,3,8],
// [11,10,4,7,1,7],
// [13,7,2,9,8,10],
// [13,1,3,4,8,6]
// [20,3,3,9,10,8]]
//
     // [[1,4,3,1,3,2]
     //  [3,2,1,3,2,4]
     //  [2,3,3,2,3,1]

}
