class Solution {
    int M = (int)1e9+7;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n==1)
            return 0;
        int[][] pascal = new int[n][n];
        pascal[1][0]=pascal[1][1]=1;
        for (int i = 2; i < n; i++){
            for (int j = 0; j <= i; j++){
                pascal[i][j]=j==0||j==i? 1 : (pascal[i-1][j]+pascal[i-1][j-1])%M;
            }
        }
        return (int)solve(Arrays.stream(nums).boxed().toList(), pascal) - 1;
    }

    private long solve(List<Integer> tree, int[][] lookup){
        if (tree.size()<=1)
            return 1;

        int slot = tree.size()-1;
        int root = tree.get(0);
        List<Integer> lo = new ArrayList<>();
        List<Integer> hi = new ArrayList<>();
        for (int n:tree){
            if (n<root){
                lo.add(n);
            }
            if (n>root){
                hi.add(n);
            }
        }
        return (((1L*lookup[slot][lo.size()] * solve(lo, lookup)) % M) * solve(hi, lookup))%M;
    }
}
