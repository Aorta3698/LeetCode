class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : similarPairs){
            map.computeIfAbsent(p.get(0), o -> new HashSet<>()).add(p.get(1));
            map.computeIfAbsent(p.get(1), o -> new HashSet<>()).add(p.get(0));
        }

        for (int i = 0; i < sentence1.length; i++)
            if (!isMatch(map, sentence1[i], sentence2[i]))
                return false;

        return true;
    }

    private static boolean isMatch(Map<String, Set<String>> map, String s, String t){
        if (s.equals(t)) return true;
        if (!map.containsKey(s)) return false;

        for (String similar : map.get(s))
            if (similar.equals(t))
                return true;

        return false;
    }
}
