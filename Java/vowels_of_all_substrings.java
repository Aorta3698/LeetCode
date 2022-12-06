class Solution {
    public long countVowels(String word) {
        long ans = 0;
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++)
            if (isVowel(arr[i]))
                ans += getCount(arr.length, i);

        return ans;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private long getCount(int len, int idx){
        long distWall = Math.min(idx + 1, len - idx);
        //1 to n. In total n times
        //1 + 2 + ... + wall + ... + wall + wall - 1 + wall - 2 + ... + 2 + 1
        return (1 + distWall) * distWall + (len - 2 * distWall) * distWall;
    }
}
