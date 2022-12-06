https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/discuss/2297284/Java-or-Space-O(2*(2(n2))-or-Cut-it-in-half
class Solution {
    public int minimumDifference(int[] nums) {
        int[][] a = gen(0, nums.length/2-1, nums);
        int[][] b = gen(nums.length/2, nums.length-1, nums);
        int i = 0, j = b.length-1, ans = Integer.MAX_VALUE, sum = Arrays.stream(nums).sum();
        for (int m = 0; m <= nums.length/2 && ans > 0 && i < a.length && j >= 0; m++){
            while(i < a.length && a[i][1]!=m){
                i++;
            }
            while(j >= 0 && b[j][1] != nums.length/2-m){
                j--;
            }
            while(i < a.length && j >= 0 && a[i][1]==m && b[j][1]==nums.length/2-m && ans > 0){
                int val = a[i][0]+b[j][0];
                ans = Math.min(ans, Math.abs(val-(sum-val)));
                if (val <= sum/2){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return ans;
    }

    private int[][] gen(int lo, int hi, int[] nums){
        int[][] res = new int[1<<(hi-lo+1)][2];
        for (int i = lo; i <= hi; i++){
            res[1<<(i-lo)][0]=nums[i];
        }
        for (int i = 1; i < res.length; i++){
            res[i][0]=res[i&-i][0]+res[i&(i-1)][0];
            res[i][1]=res[i&(i-1)][1]+1;
        }
        Arrays.sort(res, (a, b) -> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        // Arrays.sort(res, Comparator.<int[]>comparingInt(o -> o[1]).thenComparing(o -> o[0]));
        return res;
    }
}
