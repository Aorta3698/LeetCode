class Solution {
    public int maxTurbulenceSize(int[] arr) {
        return Math.max(find(arr, 0), find(arr, 1));
    }

    private int find(int[] arr, int d){
        int ans = 1, count = 1;
        for (int i = 0; i < arr.length - 1; i++){
            if (i % 2 == d){
                if (arr[i] > arr[i + 1]){
                    ++count;
                }else{
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }else{
                if (arr[i] < arr[i + 1]){
                    ++count;
                }else{
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
        }

        return Math.max(ans, count);
    }
}
