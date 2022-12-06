class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray())
            arr[ch-'a']++;

        int odd = 0;
        for (int i : arr){
            if (i % 2 == 1)
                odd++;
            if (odd >= 2)
                return false;
        }

        return true;
    }
}
