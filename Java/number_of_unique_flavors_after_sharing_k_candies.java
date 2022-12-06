https://leetcode.com/problems/number-of-unique-flavors-after-sharing-k-candies/discuss/1630838/Java-or-O(n)-or-Sliding-Window-or-Comments
class Solution {
    public int shareCandies(int[] candies, int k) {
        int[] count = new int[100001];
        int unique = 0;
        for (int candy : candies)
            if (++count[candy] == 1)
                unique++;

        int lose = 0;
        for (int i = 0; i < k; i++)
            if (--count[candies[i]] == 0)
                lose++;

        int min = lose;
        for (int i = k; i < candies.length; i++){
            if (--count[candies[i]] == 0) lose++;
            if (++count[candies[i - k]] == 1) lose--;
            min = Math.min(lose, min);
        }

        return unique - min;
    }
}
