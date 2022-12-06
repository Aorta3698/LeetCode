https://leetcode.com/problems/count-vowel-substrings-of-a-string/discuss/1626092/Java-or-99-Speed-or-Similar-to-1358.-Number-of-Substrings-Containing-All-Three-Characters
class Solution {
    public int countVowelSubstrings(String word) {
        char[] arr = word.toCharArray();
        int[] count= new int[26];

        int j = 0;
        int ans = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++){
            if(!isVowel(arr[i])) {count = new int[26]; j = i + 1; continue;}

            count[arr[i] - 'a']++;
            if (i >= end) end = i + 1;
            while(j < arr.length && found(count)){
                while(end < arr.length && isVowel(arr[end])) end++;
                ans += end - i;
                count[arr[j++] - 'a']--;
            }
        }

        return ans;
    }

    private static boolean found(int[] count){
        return count['a' - 'a'] > 0 && count['e' - 'a'] > 0
            && count['i' - 'a'] > 0 && count['o' - 'a'] > 0
            && count['u' - 'a'] > 0;
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}
