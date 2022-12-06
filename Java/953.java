class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] o = new int[26];
        for (int i = 0; i < order.length(); i++) o[order.charAt(i) - 'a'] = i;
        String[] copy = words.clone();
        Arrays.sort(copy, (a, b) ->{
            for (int i = 0; i < Math.min(a.length(), b.length()); i++){
                int x = a.charAt(i) - 'a', y = b.charAt(i) - 'a';
                if (o[x] < o[y]) return -1;
                if (o[x] > o[y]) return 1;
            }
            return a.length() - b.length();
        });

        return Arrays.equals(copy, words);
    }
}
