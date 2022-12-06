class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Set.of(""));
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int max = 0;
        for (String b : banned) set.add(b);

        StringBuilder sb = new StringBuilder();
        String delim = "!?',;. ";
        for (int i = 0; i < paragraph.length(); i++){
            char ch = paragraph.charAt(i);
            if (delim.contains(String.valueOf(ch)) || i == paragraph.length() - 1){
                if (!delim.contains(String.valueOf(ch))) sb.append(Character.toLowerCase(ch));
                String w = sb.toString();
                sb.setLength(0);
                if (set.contains(w)) continue;
                if (map.merge(w, 1, Integer::sum) > max) {max = map.get(w); ans = w;}
            }else{
                sb.append(Character.toLowerCase(ch));
            }
        }

        return ans;
    }
}
