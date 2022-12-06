class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        int mid = nums.length/2;
        int[] fArr = Arrays.copyOfRange(nums, 0, mid);
        int[] lArr = Arrays.copyOfRange(nums, mid, nums.length);

        fArr = sortArray(fArr);
        lArr = sortArray(lArr);

        return merge(fArr, lArr);
    }

    private int[] merge(int[] f, int[] l){
        int[] ans = new int[f.length+l.length];
        int fIdx = 0;
        int lIdx = 0;

        for (int i = 0; i < ans.length; i++){
            if (fIdx < f.length && (lIdx == l.length || f[fIdx] < l[lIdx]))
                ans[i] = f[fIdx++];
            else
                ans[i] = l[lIdx++];
        }

        return ans;
    }
}
