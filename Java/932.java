class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size() < n){
            List<Integer> next = new ArrayList<>();
            for (int m : ans){
                if (2*m-1<=n){
                    next.add(2*m-1);
                }
            }
            for (int m : ans){
                if (2*m<=n){
                    next.add(2*m);
                }
            }
            ans = next;
        }
        return ans.stream().mapToInt(o -> o).toArray();
    }
}
