class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> ans = new ArrayList<>();
        Set<String> target = new HashSet<>();
        for (String w : words) target.add(w);

        for (int i = 0; i < text.length(); i++)
            for (int j = i + 1; j <= text.length(); j++)
                if (target.contains(text.substring(i, j)))
                    ans.add(new int[]{i, j - 1});

        return ans.toArray(new int[0][]);
    }
}
