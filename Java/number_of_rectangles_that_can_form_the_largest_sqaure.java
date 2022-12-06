class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] r : rectangles)
            map.merge(Math.min(r[0], r[1]), 1, Integer::sum);

        return map.get(map.lastKey());
    }
}
