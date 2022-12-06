class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> ans = new ArrayList<>();
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int[] b : segments){
            map.merge(b[0], (long) b[2], Long::sum);
            map.merge(b[1], (long)-b[2], Long::sum);
        }

        long sum = 0, start = -1;
        for (int key : map.keySet()){
            if (start >= 0 && sum > 0) ans.add(List.of(start, (long)key, sum));
            start = key;
            sum += map.get(key);
        }

        return ans;
    }
}
