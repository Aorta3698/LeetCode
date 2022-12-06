class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int ans = 0;
        for (int i = 0; i < boxTypes.length && truckSize>0; i++){
            int take = Math.min(truckSize, boxTypes[i][0]);
            ans += take * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }
        return ans;
    }
}
