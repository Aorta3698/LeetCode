class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max = 0;
        for (int i = -radius; i <= 50 + radius; i++){
            for (int j = -radius; j <= 50 + radius; j++){
                int sum = 0;
                for (int[] t : towers){
                    int d = (t[0] - i) * (t[0] - i) + (t[1] - j) * (t[1] - j);
                    if (d <= radius * radius){
                        sum += (int)(t[2] / (1.0 + Math.sqrt(d)));
                    }
                }
                if (sum > max){
                    max = sum;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
