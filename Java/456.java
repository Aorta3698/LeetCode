class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int two = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--){
            if (two > nums[i])
                return true;
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                two = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}

// class Solution {
//     public boolean find132pattern(int[] nums) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for (int i = 1; i < nums.length; i++){
//             map.merge(nums[i], 1, Integer::sum);
//         }
//         int min = nums[0];
//         for (int i = 1; i < nums.length - 1; i++){
//             Integer two = map.lowerKey(nums[i]);
//             if (two != null && two > min)
//                 return true;
//             if (map.merge(nums[i], -1, Integer::sum) == 0){
//                 map.remove(nums[i]);
//             }
//             min = Math.min(min, nums[i]);
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean find132pattern(int[] nums) {
//         int n = nums.length;
//         Map<Integer, Integer>[] map = new HashMap[n];
//         Arrays.setAll(map, o -> new HashMap<>());
//         for (int i = 0; i < n; i++){
//             map[i].put(i, nums[i]);
//         }

//         for (int i = 2; i < n; i <<= 1){
//             for (int j = 0; j + i - 1 < n; j++){
//                 int l = map[j].get(j + (i >> 1) - 1);
//                 int r = map[j + i - (i >> 1)].get(j + i - 1);
//                 map[j].put(j + i - 1, Math.min(l, r));
//             }
//         }

//         for (int i = 1; i < n - 1; i++){
//             if (min(0, i - 1, map) < nums[i] && min(i + 1, n - 1, map) < nums[i]){
//                 return true;
//             }
//         }

//         return false;
//     }

//     private int min(int i, int j, Map<Integer, Integer>[] map){
//         int range = j - i + 1;
//         while((range & (range - 1)) > 0){
//             range &= (range - 1);
//         }
//         return Math.min(map[i].get(i + range - 1), map[j - range + 1].get(j));
//     }
// }
