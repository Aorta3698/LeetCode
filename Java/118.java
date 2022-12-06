class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[] p = new int[numRows];
        p[0]=1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            for (int j = i; j >= 0; j--){
                p[j]+=j==0?0:p[j-1];
            }
            ans.add(Arrays.stream(p).filter(o -> o > 0).boxed().toList());
        }
        return ans;
    }
}
