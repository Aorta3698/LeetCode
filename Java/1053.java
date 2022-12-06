class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int idx = -1, n = arr.length;
        for (int i = n - 1; i > 0; i--){
            if (arr[i - 1] > arr[i]){
                idx = i - 1;
                break;
            }
        }
        if (idx == -1)
            return arr;
        int j = n;
        for (int i = idx + 1; i < n && arr[i] < arr[idx]; i++){
            if (arr[i] != arr[i - 1]){
                j = i;
            }
        }
        int tmp = arr[j];
        arr[j] = arr[idx];
        arr[idx] = tmp;

        return arr;
    }
}
