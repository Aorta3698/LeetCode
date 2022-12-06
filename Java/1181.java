// class Solution {
//     public List<String> beforeAndAfterPuzzles(String[] phrases) {
//         Map<String, Set<String>> head = new HashMap<>();
//         Map<String, Integer> count = new HashMap<>();
//         Map<String, Integer> endMap = new HashMap<>();
//         for (String s : phrases){
//             int end = s.indexOf(" ");
//             if (end == -1) {
//                 end = s.length();
//             }
//             head.computeIfAbsent(s.substring(0, end), o -> new HashSet<>()).add(s);
//             count.merge(s, 1, Integer::sum);
//             endMap.put(s, end);
//         }

//         TreeSet<String> ans = new TreeSet<>();
//         for (String s : phrases){
//             for (String t : head.getOrDefault(s.substring(s.lastIndexOf(" ") + 1), Set.of())){
//                 if (!s.equals(t) || count.get(s) > 1){
//                     ans.add(s + t.substring(endMap.get(t)));
//                 }
//             }
//         }

//         return new ArrayList<>(ans);
//     }
// }

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Map<String, Integer>> head = new HashMap<>();
        int[] idx = new int[phrases.length];
        for (int i = 0; i < phrases.length; i++){
            String s = phrases[i];
            int end = s.indexOf(" ");
            if (end == -1) {
                end = s.length();
            }
            head.computeIfAbsent(s.substring(0, end), o -> new HashMap<>())
                .merge(s.substring(end), 1, Integer::sum);
            idx[i] = end;
        }

        TreeSet<String> ans = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++){
            String s = phrases[i];
            Map<String, Integer> tail = head.get(s.substring(s.lastIndexOf(" ") + 1));
            if (tail == null) {
                continue;
            }
            String h = s.substring(0, idx[i]);
            String rest = s.substring(idx[i]);
            head.get(h).merge(rest, -1, Integer::sum);

            for (String t : tail.keySet()){
                if (tail.get(t) > 0){
                    ans.add(s + t);
                }
            }

            head.get(h).merge(rest, 1, Integer::sum);
        }

        return new ArrayList<>(ans);
    }
}
