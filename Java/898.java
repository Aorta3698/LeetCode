class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>(), prev = new HashSet<>();
        for (int n : arr){
            Set<Integer> cur = new HashSet<>();
            cur.add(n);
            for (int m : prev){
                cur.add(m | n);
            }
            ans.addAll(cur);
            prev = cur;
        }
        return ans.size();
    }
}
