https://leetcode.com/problems/palindrome-permutation-ii/discuss/1856176/Java-Backtracking-with-a-HashMap
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.merge(ch, 1, Integer::sum);
        }

        char mid = 'A';
        for (Character key : map.keySet()){
            if (map.get(key) % 2 == 1){
                if (mid != 'A'){
                    return ans;
                }
                mid = key;
            }
            map.put(key, map.get(key) / 2);
        }

        generate(map, ans, new StringBuilder(), s.length() / 2, mid);
        return ans;
    }

    private void generate(Map<Character, Integer> map, List<String> ans, StringBuilder sb, int end, char mid){
        if (sb.length() == end){
            ans.add(sb.toString() + (mid == 'A'? "" : mid) + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (Character key : map.keySet()){
            if (map.get(key) == 0) continue;
            map.merge(key, -1, Integer::sum);
            sb.append(key);
            generate(map, ans, sb, end, mid);
            sb.setLength(sb.length() - 1);
            map.merge(key, 1, Integer::sum);
        }
    }
}
