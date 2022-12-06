https://leetcode.com/problems/reformat-the-string/discuss/1640405/Java-or-8-Lines-or-ArrayDeque
class Solution {
    public String reformat(String s) {
        Deque<Character>[] store = new ArrayDeque[2];
        for (int i = 0; i < store.length; i++) store[i] = new ArrayDeque<>();
        for (char ch : s.toCharArray())
            store[Character.isAlphabetic(ch)? 0 : 1].push(ch);

        if (Math.abs(store[0].size() - store[1].size()) > 1) return "";

        StringBuilder sb = new StringBuilder();
        for (int first = store[0].size() > store[1].size()? 0 : 1; !store[first].isEmpty(); first = 1 - first)
            sb.append(store[first].pop());

        return sb.toString();
    }
}
