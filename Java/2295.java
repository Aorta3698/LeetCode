class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (int[] o : operations){
            int idx = map.get(o[0]);
            map.remove(o[0]);
            map.put(o[1], idx);
        }
        for (int key : map.keySet()){
            nums[map.get(key)] = key;
        }
        return nums;
    }
}
