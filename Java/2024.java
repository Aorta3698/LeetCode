class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int n = answerKey.length(), ans = 0;
        int[] tprefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T')
                tprefix[i]++;
            if (i > 0)
                tprefix[i] += tprefix[i - 1];
        }

        for (int i = 0; i < n; i++){
            int lo = i, hi = n - 1;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2 + 1;
                if (ok(i, mid, tprefix, arr[i], k)) lo = mid;
                else hi = mid - 1;
            }
            ans = Math.max(lo - i + 1, ans);
        }

        return ans;
    }

    private boolean ok(int start, int guess, int[] pre, char ch, int limit){
        int TtoF = pre[guess] - pre[start] + (ch == 'T'? 1 : 0);
        int FtoT = guess - start - pre[guess] + pre[start] + (ch == 'F'? 1 : 0);
        return Math.min(TtoF, FtoT) <= limit;
    }
}
