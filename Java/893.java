class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> seen = new HashSet<>();
        for (String w : words){
            int[] count = new int[52];
            int i = 0;
            for (char ch : w.toCharArray()){
                count[++i % 2 == 0? ch - 'a' : ch + 26 - 'a']++;
            }
            seen.add(Arrays.toString(count));
        }

        return seen.size();
    }
}
