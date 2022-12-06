class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int e = 1;
        for (int i = 0; i < target.length; i++){
            while(e < target[i]){
                ans.add("Push");
                ans.add("Pop");
                e++;
            }
            ans.add("Push");
            e++;
        }

        return ans;
    }
}
