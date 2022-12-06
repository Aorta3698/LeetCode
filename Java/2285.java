class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] r : roads){
            count[r[0]]++;
            count[r[1]]++;
        }
        Arrays.sort(count);
        long ans = 0;
        for (int i = count.length - 1; i >= 0; i--){
            ans += 1L * count[i] * n--;
        }
        return ans;
    }
}
