class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> pre = new HashMap<>(Map.of(0, -1));
        Map<Integer, Integer> suf = new HashMap<>(Map.of(0, arr.length));
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        int a = 0, b = 0, MAX = (int)1e9;

        for (int i = 0; i < arr.length; i++){
            a += arr[i];
            b += arr[arr.length - 1 - i];
            int j = arr.length - i - 1;
            int x = i - pre.getOrDefault(a - target, i - MAX);
            int y = suf.getOrDefault(b - target, MAX + j) - j;
            prefix[i] = Math.min(i > 0? prefix[i - 1] : MAX, x);
            suffix[j] = Math.min(i > 0? suffix[j + 1] : MAX, y);
            pre.put(a, i);
            suf.put(b, j);
        }

        int ans = MAX;
        for (int i = 1; i < arr.length; i++){
            ans = Math.min(ans, prefix[i - 1] + suffix[i]);
        }

        return ans >= MAX? -1 : ans;
    }
}
