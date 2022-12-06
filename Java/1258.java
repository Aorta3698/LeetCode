https://leetcode.com/problems/synonymous-sentences/discuss/1866690/Java-Concise-100-Speed-2ms-Solution
class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ans = new ArrayList<>();
        String[] words = text.split(" ");
        Map<Integer, Set<String>> map = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for (List<String> syn : synonyms){
            union(syn.get(0), syn.get(1), parent);
        }

        List<String> syn = new ArrayList<>(parent.keySet());
        for (int i = 0; i < words.length; i++){
            map.computeIfAbsent(i, o -> new HashSet<>()).add(words[i]);
            for (String s : syn){
                if (find(s, parent).equals(find(words[i], parent))){
                    map.get(i).add(s);
                }
            }
        }

        dfs(0, map, words, new StringBuilder(), ans);
        Collections.sort(ans);
        return ans;
    }

    private void dfs(int i, Map<Integer, Set<String>> map, String[] words, StringBuilder sb, List<String> ans){
        if (i == words.length){
            ans.add(sb.toString());
            return;
        }

        for (String s : map.get(i)){
            int rev = s.length();
            sb.append(s);
            if (i < words.length - 1){
                sb.append(' ');
                rev++;
            }
            dfs(i + 1, map, words, sb, ans);
            sb.setLength(sb.length() - rev);
        }
    }

    private String find(String s, Map<String, String> parentMap){
        parentMap.putIfAbsent(s, s);
        String parent = parentMap.get(s);
        if (!parent.equals(s)){
            parentMap.put(s, find(parent, parentMap));
        }
        return parentMap.get(s);
    }

    private void union(String s, String t, Map<String, String> parentMap){
        s = find(s, parentMap);
        t = find(t, parentMap);
        parentMap.put(s, t);
    }
}
