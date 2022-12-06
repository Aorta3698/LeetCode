class Solution {
    public boolean wordPattern(String pattern, String s) {
        return hash(pattern, 0) == hash(s, 1);
    }

    private int hash(String s, int mode){
        String pattern = mode == 0? "{1}" : " ";
        String[] words = s.split(pattern);
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            if (!map.containsKey(w))
                map.put(w, map.size());

        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(map.get(w));

        return sb.toString().hashCode();
    }
}
