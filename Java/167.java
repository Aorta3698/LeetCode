class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int lo = 0, hi = numbers.length - 1;
        while(true){
            int sum = numbers[lo]+numbers[hi];
            if (sum > target){
                hi--;
            }else if (sum < target){
                lo++;
            }else{
                return new int[]{++lo, ++hi};
            }
        }
    }
}
