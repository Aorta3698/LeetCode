class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0; --i){
            ans += Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            if (truckSize <= 0) break;
        }

        return ans;
    }
}
