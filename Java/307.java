class NumArray {

    int[] bit;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=new int[nums.length];
        bit = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }

    public void update(int idx, int val) {
        val -= nums[idx];
        nums[idx]+=val;
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx] += val;
        }
    }

    public int sumRange(int left, int right) {
        return sum(right)-sum(left-1);
    }

    private int sum(int idx){
        int ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
