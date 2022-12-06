class Solution {
    public int magicalString(int n) {
        if (n <= 3)
            return 1;

        int[] arr = new int[n];
        arr[1] = arr[2] = 2;
        arr[0] = 1;
        int ans = 1;

        for (int i = 3, j = 1, count = 2; i < n; i++, count++){
            if (count == arr[j]){
                arr[i] = 3 - arr[i - 1];
                count = 0;
                j++;
            }else{
                arr[i] = arr[i - 1];
            }
            if (arr[i] == 1){
                ans++;
            }
        }

        return ans;
    }
}
