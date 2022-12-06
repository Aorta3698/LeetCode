class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        Set[] copy = new HashSet[arrays.length];
        for (int i = 0; i < copy.length; i++)
            copy[i] = new LinkedHashSet<>();

        for (int i = 0; i < arrays.length; i++)
            for (int j = 0; j < arrays[i].length; j++)
                copy[i].add(arrays[i][j]);

        Set<Integer> ans = copy[0];
        for (int i = 1; i < copy.length; i++)
            ans = retainAll(copy[i], ans);

        return new ArrayList<>(ans);
    }

    private Set<Integer> retainAll(Set<Integer> row, Set<Integer> set){
        Set<Integer> ans = new LinkedHashSet<>(set);
        for (int num : set)
            if (!row.contains(num))
                ans.remove((Integer) num);

        return ans;
    }
}
