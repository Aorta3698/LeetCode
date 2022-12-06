class Solution {
    public boolean areSentencesSimilarTwo(String[] one, String[] two, List<List<String>> pairs) {
        if (one.length != two.length) return false;

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < one.length; i++){
            map.put(one[i], one[i]);
            map.put(two[i], two[i]);
        }
        for (List<String> pair : pairs){
            union(pair.get(0), pair.get(1), map);
        }
        for (int i = 0; i < one.length; i++){
            if (!find(one[i], map).equals(find(two[i], map))){
                return false;
            }
        }
        return true;
    }

    private String find(String s, Map<String, String> map){
        map.putIfAbsent(s, s);
        String parent = map.get(s);
        if (!parent.equals(s)){
            map.put(s, find(parent, map));
        }
        return map.get(s);
    }

    private void union(String s, String t, Map<String, String> map){
        s = find(s, map);
        t = find(t, map);
        if (s.equals(t)) return;
        map.put(s, t);
    }
}
