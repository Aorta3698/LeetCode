class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length, M = 100001;
        long[] ans = new long[n];
        long[] forSum = new long[M], backSum = new long[M];
        int[] forCnt = new int[M], backCnt = new int[M];
        for (int i = 0; i < n; i++){
            forSum[arr[i]] += i;
            forCnt[arr[i]]++;
        }

        for (int i = 0; i < n; i++){
            long forward = forSum[arr[i]] - (long)i * forCnt[arr[i]];
            long backward= (long)i * backCnt[arr[i]] - backSum[arr[i]];
            ans[i] = forward + backward;
            backSum[arr[i]] += i;
            forSum[arr[i]] -= i;
            forCnt[arr[i]]--;
            backCnt[arr[i]]++;
        }

        return ans;
    }
}
