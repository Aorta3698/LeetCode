class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> xList = new ArrayList<>();
        for (int[] p : points)
            xList.add(p[0]);

        Collections.sort(xList);

        int ans = 0;
        for (int i = 0; i < xList.size() - 1; i++)
            ans = Math.max(ans, Math.abs(xList.get(i) - xList.get(i + 1)));

        return ans;
    }
}
