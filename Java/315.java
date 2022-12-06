class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] bit = new int[20002];
        for (int i = 0; i < nums.length; i++){
            nums[i]+=10000;
            update(bit, 1, nums[i]);
        }
        for (int n : nums){
            update(bit, -1, n);
            ans.add(sum(bit, n-1) - sum(bit, -1));
        }
        return ans;
    }

    void update(int[] bit, int inc, int idx){
        ++idx;
        while(idx < bit.length){
            bit[idx] += inc;
            idx += idx & -idx;
        }
    }

    int sum(int[] bit, int idx){
        ++idx;
        int ans = 0;
        while(idx > 0){
            ans += bit[idx];
            idx -= idx & -idx;
        }
        return ans;
    }
}





https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/1649477/Java-BruceForce-7-Lines-Accepted-w-Bits-(Bottom-10)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length];
        Integer[] idx = IntStream.range(0, nums.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, (a, b) -> nums[a] == nums[b]? a - b : nums[a] - nums[b]);
        BitSet set = new BitSet();
        for (int n : idx){
            ans[n] = set.get(n, nums.length).cardinality();
            set.set(n);
        }

        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
