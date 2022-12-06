https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/discuss/1925139/Keep-track-of-First-number-with-a-sign-or-Java
class Solution {
    public int getMaxLen(int[] nums) {
        int ans = 0, sign = 0, MAX = (int)1e5;
        int[] pos = new int[]{-1, MAX};

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                sign = 0;
                pos[0] = pos[1] = MAX;
            }else if (nums[i] < 0){
                sign = 1 - sign;
            }
            if (pos[sign] == MAX){
                pos[sign] = i;
            }
            ans = Math.max(ans, i - pos[sign]);
        }

        return ans;
    }
}

// class Solution {
//     public int getMaxLen(int[] nums) {
//         int ans = 0, count = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);

//         for (int i = 0; i < nums.length; i++){
//             if (nums[i] == 0){
//                 count = 0;
//                 map.clear();
//             }else if (nums[i] < 0){
//                 count = 1 - count;
//             }
//             map.putIfAbsent(count, i);
//             ans = Math.max(ans, i - map.getOrDefault(count, i));
//         }

//         return ans;
//     }
// }
