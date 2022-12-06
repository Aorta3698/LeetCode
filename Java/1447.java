class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            ans.add(String.format("1/%d", i));
            int[] invalid = new int[i+1];
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    for (int w = j; w <= i; w += j)
                        invalid[w] = 1;
                }
                else if (invalid[j] == 0) {
                    ans.add(String.format("%d/%d", j, i));
                }
            }
        }

        return ans;
    }
}
