class Solution {
    public int[] replaceElements(int[] arr) {
        int[] max = maxIdx(arr, 0);
        for (int i = 0; i < arr.length; i++){
            if (i >= max[0]) max = maxIdx(arr, i+1);
            arr[i] = max[1];
        }

        return arr;
    }

    private int[] maxIdx(int[] arr, int start){
        int [] max = {0, -1};
        for (int i = start; i < arr.length; i++)
            if (arr[i]>max[1]) max = new int[]{i, arr[i]};
        return max;
    }
}
