class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> seen = new HashSet<>();
        for (String s : startWords) seen.add(hash(s));
        int ans = 0;
        for (String t : targetWords){
            int hash = hash(t);
            for (char ch : t.toCharArray())
                if (seen.contains(hash ^ (1 << (ch - 'a'))) && ++ans > 0)
                    break;
        }

        return ans;
        // boolean[] data = new boolean[1 << 27];
        // for (String s : startWords) data[hash(s)] = true;
        // int ans = 0;
        // for (String t : targetWords){
        //     int hash = hash(t);
        //     for (char ch : t.toCharArray())
        //         if (data[hash ^ (1 << (ch - 'a'))] && ++ans > 0)
        //             break;
        // }

        // return ans;
    }

    private int hash(String s){
        int sum = 0;
        for (char ch : s.toCharArray())
            sum |= (1 << (ch - 'a'));
        return sum;
    }
}
