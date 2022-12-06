https://leetcode.com/problems/statistics-from-a-large-sample/discuss/1932376/Java-One-Pass-Concise
class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        ans[0] = IntStream.range(0, count.length).dropWhile(o -> count[o] == 0).findFirst().getAsInt();
        ans[4] = IntStream.range(0, count.length).reduce((a, b) -> count[a] > count[b]? a : b).getAsInt();
        int cnt = Arrays.stream(count).sum(), cur = -1, half = (cnt - 1) / 2;
        for (int i = 0; i < count.length; i++){
            if (count[i] == 0)
                continue;
            if (cur + count[i] >= half && cur < half){
                ans[3] += (1 + cnt % 2) * 0.5f * i;
            }
            if (cnt % 2 == 0 && cur + count[i] >= half + 1 && cur < half + 1){
                ans[3] += 0.5f * i;
            }
            ans[1] = i;
            ans[2] += 1f * i * count[i] / cnt;
            cur += count[i];
        }
        return ans;
    }
}
