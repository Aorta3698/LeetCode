class Solution {
    public int maxNumberOfApples(int[] weight) {
        int cap = 5000;
        Arrays.sort(weight);
        int ans = 0;
        for (int w : weight){
            cap -= w;
            if (cap < 0) break;
            ans++;
        }

        return ans;
    }
}
