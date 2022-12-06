https://leetcode.com/problems/average-height-of-buildings-in-each-segment/discuss/1714374/Java-Concise-TreeMap-18-Lines
class Solution {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int[] b : buildings){
            map.merge(b[0],  b[2], Integer::sum);
            map.merge(b[1], -b[2], Integer::sum);
            cntMap.merge(b[0],  1, Integer::sum);
            cntMap.merge(b[1], -1, Integer::sum);
        }

        int sum = 0, cnt = 0, start = -1, average = 0;
        for (int key : map.keySet()){
            sum += map.get(key);
            cnt += cntMap.get(key);
            int nextAverage = cnt > 0? sum / cnt : 0;
            if (nextAverage == average) continue;
            if (start >= 0 && average > 0) ans.add(new int[]{start, key, average});
            average = nextAverage;
            start = key;
        }

        return ans.toArray(new int[0][]);
    }
}
