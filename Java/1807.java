class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) map.put(k.get(0), k.get(1));
        for (int i = 0, d = -1; i < s.length(); i++){
            if (s.charAt(i) == '(') d = i;
            else if (s.charAt(i) == ')') {
                sb.append(map.getOrDefault(s.substring(d + 1, i), "?"));
                d = -1;
            }
            else if (d == -1) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
