class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] birth = new int[2051];
        int[] death = new int[2051];
        for (int[] g : logs){
            ++birth[g[0]];
            ++death[g[1]];
        }

        int ans = 0, count = 0, max = 0;
        for (int i = 1950; i <= 2050; i++){
            count += birth[i] - death[i];
            if (count > max){
                max = count;
                ans = i;
            }
        }

        return ans;
    }
}
