class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        List<Integer>[] list = new ArrayList[2];
        for (int i = 0; i < 2; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list[i & 1].add(nums[i]);
        }
        int[] ans = new int[n];
        Collections.sort(list[0]);
        Collections.sort(list[1], Comparator.reverseOrder());
        Iterator<Integer> even = list[0].iterator();
        Iterator<Integer> odd  = list[1].iterator();
        for (int i = 0; i < n; i++){
            ans[i] = i % 2 == 0? even.next() : odd.next();
        }

        return ans;
    }
}
