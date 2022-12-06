https://leetcode.com/problems/pour-water/discuss/1928381/Java-or-Simulate-Moving-it
class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++){
            if (!move(heights, k, -1) && !move(heights, k, 1)){
                heights[k]++;
            }
        }

        return heights;
    }

    private boolean move(int[] heights, int k, int d){
        int min = k;
        for (int i = k;  i >= 0 && i < heights.length; i += d){
            if (i != k && heights[i] > heights[i - d])
                break;
            if (heights[i] < heights[min]){
                min = i;
            }
        }
        if (min != k){
            heights[min]++;
        }
        return min != k;
    }
}
