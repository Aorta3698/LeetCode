class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = n - 1; i > 0; i--){
            if (arr[i] == i + 1) continue;

            int j = 0;
            for (; j < i; j++)
                if (arr[j] == i + 1)
                    break;
            if (j > 0) {ans.add(j + 1); flip(arr, 0, j);}
            ans.add(i + 1);
            flip(arr, 0, i);
        }

        return ans;
    }

    private static void flip(int[] arr, int lo, int hi){
        while(lo < hi){
            int tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++; hi--;
        }
    }
}
