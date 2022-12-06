class Solution {
    public int firstUniqChar(String s) {
        int[] eng = new int[26];
        for (char ch : s.toCharArray())
            eng[ch-'a']++;
        for (int i = 0; i < s.length(); i++)
            if (eng[s.charAt(i)-'a'] == 1)
                return i;

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++)
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // for (int i = 0; i < s.length(); i++)
        //     if (map.get(s.charAt(i)) < 2)
        //         return i;

        return -1;
    }
}
