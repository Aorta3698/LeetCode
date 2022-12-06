class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = IntStream.range(0, n).toArray();
        int ans = 0, miss = 0;
        do{
            int[] next = new int[n];
            for (int i = 0; i < n; i++){
                next[i] = i % 2 == 0? arr[i / 2] : arr[n / 2 + (i - 1) / 2];
                if (arr[i] == i && arr[i] != next[i]) miss++;
                else if (arr[i] != i && next[i] == i) miss--;
            }
            arr = next;
            ans++;
        }while(miss != 0);

        return ans;
    }
}
