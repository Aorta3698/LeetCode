class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            while(right < s.length() && set.add(s.charAt(right)))
                right++;

            count = Math.max(count, right - left);

            if (right == s.length()) break;

            do{
                set.remove(s.charAt(left));
            }
            while(left < right && s.charAt(left++) != s.charAt(right));
                // set.remove(s.charAt(left++));
            // set.remove(s.charAt(left++));
        }

        return count;
        // int count = 0;
        // for (int i = 0; i < s.length(); i++){
        //     Set<Character> set = new HashSet<>();
        //     for (int j = i; j < s.length(); j++){
        //         if(!set.add(s.charAt(j)))
        //             break;
        //     }
        //     count = Math.max(count, set.size());
        // }

        // return count;
    }
}
