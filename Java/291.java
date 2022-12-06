https://leetcode.com/problems/word-pattern-ii/discuss/1856256/Java-BackTracking-with-one-hashmap
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrack(0, pattern, 0, s, new HashMap<>());
    }

    private boolean backtrack(int i, String p, int j, String s, Map<Character, String> map){
        if (i == p.length()){
            return j == s.length();
        }

        String cur = map.get(p.charAt(i));
        if (cur != null){
            if (!s.substring(j).startsWith(cur)){
                return false;
            }
            if (backtrack(i + 1, p, j + cur.length(), s, map)){
                return true;
            }
        }else{
            for (int k = 1; k <= s.length() - j; k++){
                String seg = s.substring(j, j + k);
                if (!map.containsValue(seg)){
                    map.put(p.charAt(i), seg);
                    if (backtrack(i + 1, p, j + k, s, map)){
                        return true;
                    }
                    map.remove(p.charAt(i));
                }
            }
        }

        return false;
    }
}

//
// class Solution {
//     public boolean wordPatternMatch(String pattern, String s) {
//         return backtrack(0, pattern, 0, s, new HashMap<>(), new HashSet<>());
//     }

//     private boolean backtrack(int i, String p, int j, String s, Map<Character, String> map, Set<String> seen){
//         if (i == p.length()){
//             return j == s.length();
//         }

//         String cur = map.get(p.charAt(i));
//         if (cur != null){
//             if (!s.substring(j).startsWith(cur)){
//                 return false;
//             }
//             if (backtrack(i + 1, p, j + cur.length(), s, map, seen)){
//                 return true;
//             }
//         }else{
//             for (int k = 1; k <= s.length() - j; k++){
//                 String seg = s.substring(j, j + k);
//                 if (seen.add(seg)){
//                     map.put(p.charAt(i), seg);
//                     if (backtrack(i + 1, p, j + k, s, map, seen)){
//                         return true;
//                     }
//                     seen.remove(seg);
//                     map.remove(p.charAt(i));
//                 }
//             }
//         }

//         return false;
//     }
// }
