https://leetcode.com/problems/split-array-with-same-average/discuss/2306444/Two-Sum-or-45-ms-or-O(N2-*-2(N2))-or-Similar-Questions
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = Arrays.stream(nums).sum();
        Set<Integer>[] a = new HashSet[n/2+1];
        Set<Integer>[] b = new HashSet[n/2+2];
        Arrays.setAll(a, o -> new HashSet<>());
        Arrays.setAll(b, o -> new HashSet<>());
        gen(0, n/2, 0, 0, nums, a);
        gen(n/2, n, 0, 0, nums, b);
        for (int i = 0; i < a.length; i++){ // i = num of elements selected from A
            for (int j = 0; j < b.length; j++){ // j = num of elements selected from B
                if (i+j>0 && i+j < n && sum*(i+j)%n == 0){
                    for (int cur : a[i]){ // do Two Sum
                        if (b[j].contains(sum*(i+j)/n-cur)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void gen(int cur, int n, int bits, int sum, int[] nums, Set<Integer>[] set){
        set[bits].add(sum);
        if (cur < n){
            gen(cur+1, n, bits+1, sum+nums[cur], nums, set);
            gen(cur+1, n, bits, sum, nums, set);
        }
    }
}

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = Arrays.stream(nums).sum();
        Set<Integer>[] a = gen(0, n/2-1, nums);
        Set<Integer>[] b = gen(n/2, n-1, nums);
        for (int i = 0; i < a.length; i++){
            for (int cur : a[i]){
                for (int j = 0; j < b.length; j++){
                    int T = (i+j)*sum - n*cur;
                    if (i + j > 0 && i + j < n && T%n==0 && b[j].contains(T/n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Set<Integer>[] gen(int lo, int hi, int[] nums){
        int sz = hi-lo+1;
        Set<Integer>[] ans = new HashSet[sz+1];
        Arrays.setAll(ans, o -> new HashSet<>());
        ans[0].add(0);
        int[] bits = new int[1<<sz];
        int[] sum = new int[1<<sz];
        for (int i = 0; i < sz; i++){
            sum[1<<i]=nums[lo+i];
        }
        for (int i = 1; i < 1<<sz; i++){
            bits[i]=bits[i&(i-1)]+1;
            sum[i] = sum[i&(i-1)]+sum[i&-i];
            ans[bits[i]].add(sum[i]);
        }
        return ans;
    }

}
