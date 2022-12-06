class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String w : words) map.merge(mask(w), 1, Integer::sum);

        for (String p : puzzles){
            int first = 1 << (p.charAt(0) - 'a');
            int remain = mask(p.substring(1));
            int score = map.getOrDefault(first, 0);
            for (int i = remain; i > 0; i = (i - 1) & remain)
                score += map.getOrDefault(i | first, 0);

            ans.add(score);
        }

        return ans;
    }

    private int mask(String w){
        int mask = 0;
        for (char ch : w.toCharArray())
            mask |= 1 << (ch - 'a');
        return mask;
    }
}
