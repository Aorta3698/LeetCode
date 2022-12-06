class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        for (int i = 1; i <= rowIndex; i++)
            for (int j = i; j >= 1; j--)
                ans[j] = ans[j] + ans[j - 1];

        return Arrays.asList(ans);
    }
}
