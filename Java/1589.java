class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] dis = new int[nums.length + 1];
        for (int[] r : requests){
            dis[r[0]]++;
            dis[r[1] + 1]--;
        }
        Arrays.sort(nums);
        int ans = 0, m = (int)(1e9 + 7);
        int[] sum = new int[requests.length + 1];
        for (int i = 0, cnt = 0; i < dis.length; i++){
            sum[cnt]++;
            cnt += dis[i];
        }

        for (int i = requests.length, j = nums.length; i >= 1; i--){
            while(--sum[i] >= 0){
                ans = (int)((ans + 1L * nums[--j] * i) % m);
            }
        }

        return ans;
    }
}

// SLOWER SOLUTION
// class Solution {
//     public int maxSumRangeQuery(int[] nums, int[][] requests) {
//         Map<Integer, Integer> map = new TreeMap<>();
//         for (int[] r : requests){
//             map.merge(r[0],  1, Integer::sum);
//             map.merge(r[1] + 1, -1, Integer::sum);
//         }
//         Arrays.sort(nums);
//         int count = 0, ans = 0, prev = 0, m = (int)(1e9 + 7);
//         int[] sum = new int[requests.length + 1];
//         for (int key : map.keySet()){
//             sum[count] += key - prev;
//             count += map.get(key);
//             prev = key;
//         }

//         for (int i = requests.length, j = nums.length; i >= 1; i--){
//             while(--sum[i] >= 0){
//                 ans = (int)((ans + 1L * nums[--j] * i) % m);
//             }
//         }

//         return ans;
//     }
// }
