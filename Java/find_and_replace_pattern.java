class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashSet<String> target = new HashSet<>();
        target.add(serialize(pattern));
        List<String> ans = new ArrayList<>();
        for (String word : words)
            if (target.contains(serialize(word)))
                ans.add(word);

        return ans;
    }

    private String serialize(String word){
        HashMap<Character, Integer> map = new HashMap<>(); 
        //Integer is fine because they have the same length
        //otherwise, use Character instead. (id 20 can be 20 or 2 + 0)
        StringBuilder sb = new StringBuilder();
        int id = 0;
        for (char ch : word.toCharArray()){
            map.putIfAbsent(ch, id++);
            sb.append(map.get(ch));
        }

        return sb.toString();
    }
}
