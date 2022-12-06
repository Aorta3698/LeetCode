class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed){
            map.computeIfAbsent(s.substring(0, 2), o -> new ArrayList<>()).add(s.charAt(2));
        }
        return backtrack(0, bottom, map, new StringBuilder(), new HashMap<>());
    }

    private boolean backtrack(int st, String bottom, Map<String, List<Character>> map,
            StringBuilder sb, Map<String, Boolean> memo){
        if (memo.containsKey(bottom))
            return memo.get(bottom);
        if (bottom.length() == 1)
            return true;
        if (sb.length() == bottom.length() - 1)
            return backtrack(0, sb.toString(), map, new StringBuilder(), memo);

        String cur = bottom.substring(st, st + 2);
        for (char ch : map.getOrDefault(cur, List.of())){
            sb.append(ch);
            if (backtrack(st + 1, bottom, map, sb, memo))
                return true;
            sb.setLength(sb.length() - 1);
        }

        memo.put(bottom, false);
        return false;
    }
}
// class Solution {
//     public boolean pyramidTransition(String bottom, List<String> allowed) {
//         Map<String, List<Character>> map = new HashMap<>();
//         for (String s : allowed){
//             map.computeIfAbsent(s.substring(0, 2), o -> new ArrayList<>()).add(s.charAt(2));
//         }

//         return solve(bottom, map);
//     }

//     private boolean solve(String bottom, Map<String, List<Character>> map){
//         if (bottom.length() == 1)
//             return true;
//         return backtrack(0, bottom, map, new StringBuilder());
//     }

//     private boolean backtrack(int st, String bottom, Map<String, List<Character>> map, StringBuilder sb){
//         if (sb.length() == bottom.length() - 1)
//             return solve(sb.toString(), map);
//         String cur = bottom.substring(st, st + 2);
//         for (char ch : map.getOrDefault(cur, List.of())){
//             sb.append(ch);
//             if (backtrack(st + 1, bottom, map, sb))
//                 return true;
//             sb.setLength(sb.length() - 1);
//         }
//         return false;
//     }
// }
