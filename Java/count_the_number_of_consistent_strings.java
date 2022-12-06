class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray())
            set.add(ch);

        int count = words.length;
        for (String w : words)
            for (char ch : w.toCharArray())
                if (!set.contains(ch)){
                    count--;
                    break;
                }

        return count;
    }
}
