class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] suOdd = new int[nums.length + 2];
        int[] suEven= new int[nums.length + 2];
        for (int i = nums.length + 1; i > 1; i--){
            if (i % 2 == 1) suOdd[i - 2] += suOdd[i] + nums[i - 2];
            else suEven[i - 2] += suEven[i] + nums[i - 2];
        }

        int ans = 0;
        for (int i = nums.length - 1, one = -1, two = -1; i >= 0; i--){
            if (suOdd[i] == 0){
                two = suOdd[i + 1] + suEven[0] - suEven[i];
                one = suOdd[1] - suOdd[i + 1] + suEven[i + 2];
            }else{
                two = suOdd[i + 2] + suEven[0] - suEven[i + 1];
                one = suOdd[1] - suOdd[i] + suEven[i + 1];
            }
            if (one == two) ans++;
        }

        return ans;
    }
}
