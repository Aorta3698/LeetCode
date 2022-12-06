class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        for (String w : words)
            for (String i : words)
                if (!w.equals(i) && w.contains(i))
                    ans.add(i);

        return new ArrayList<>(ans);
    }
}
