class Solution {
    public List<Integer> numOfBurgers(int A, int B) {
        List<Integer> ans = new ArrayList<>();
        int d = A - 2 * B;
        if (d < 0 || (d & 1) == 1 || B - (d >> 1) < 0){
            return ans;
        }
        ans.add(d >> 1);
        ans.add(B - ans.get(0));
        return ans;
    }
}
