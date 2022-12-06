class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> one = new HashMap<>();
        Map<String, Integer> two = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String s : s1.split(" ")) one.merge(s, 1, Integer::sum);
        for (String s : s2.split(" ")) two.merge(s, 1, Integer::sum);
        for (String s : s1.split(" "))
            if (one.get(s) == 1 && !two.containsKey(s))
                ans.add(s);
        for (String s : s2.split(" "))
            if (two.get(s) == 1 && !one.containsKey(s))
                ans.add(s);

        return ans.toArray(new String[0]);
    }
}
