class Solution {
    public int getWinner(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++){
            int j = i + 1;
            while(j < arr.length && arr[j] < arr[ans]){
                ++j;
            }
            if (j == arr.length || j - i - 1 + (ans == 0? 0 : 1) >= k)
                return arr[ans];
            ans = j;
            i = j - 1;
        }

        return arr[ans];
    }
}
