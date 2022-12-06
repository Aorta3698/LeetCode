https://leetcode.com/problems/decode-the-message/discuss/2230199/Java-or-HashMap-or-Map-space-to-space
class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>(Map.of(' ', ' '));
        for (char ch : key.toCharArray()){
            map.putIfAbsent(ch, (char)(map.size()-1+'a'));
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()){
            sb.append(map.get(ch));
        }
        return sb.toString();
    }
}
