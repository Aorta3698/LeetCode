class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] all = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < all.length; i++)
            for (char ch : all[i].toCharArray())
                map.put(ch, i);

        List<String> ans = new ArrayList<>();
        for (String w : words){
            int prev = map.get(Character.toLowerCase(w.charAt(0)));
            boolean add = true;
            for (char ch : w.toCharArray())
                if (prev != map.get(Character.toLowerCase(ch)) && add)
                    add = !add;
            if (add) ans.add(w);
        }

        return ans.toArray(new String[0]);
    }
}
