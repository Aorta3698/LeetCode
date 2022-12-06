class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0, idx = num.length;
        while(idx-- > 0 || k > 0 || carry > 0){
            int cur = carry + k % 10 + (idx >= 0? num[idx] : 0);
            carry = cur / 10;
            cur %= 10;
            k /= 10;
            ans.add(cur);
        }

        Collections.reverse(ans);
        return ans;
    }
}
