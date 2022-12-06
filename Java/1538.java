https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/discuss/1912740/Java-O(1)-Space-or-BruceForce-or-95-Speed
// This question is stuipdly hard for a medium lol
class Solution {
    public int guessMajority(ArrayReader reader) {
        int n = reader.length(), config = 0, one = 0, zero = 0;

        // Find the correct configuration for the first 5 elements.
        // Let g[i] be the query WITHOUT the element at index i
        int[] g = new int[5];
        for (int i = 0; i < 5; i++){
            int[] s = new int[]{(i + 1) % 5, (i + 2) % 5, (i + 3) % 5, (i + 4) % 5};
            Arrays.sort(s);
            g[i] = reader.query(s[0], s[1], s[2], s[3]);
        }

        // Try all 32 possible configurations and stop when we find a match
        for (int i = 0; i < 5 && ++config < 32;){
            one = Integer.bitCount(config); zero = 5 - one;
            for (i = 0; i < 5; i++){
                if (g[i] != Math.abs(zero - one + ((config & (1 << (4 - i))) == 0? -1 : 1)))
                    break;
            }
        }

        // Find the majority element indexes.
        int score = Math.abs(one - zero);
        int target = zero > one? 0 : 1;
        int[] majority = new int[3];
        for (int i = 0, j = 0; j < 3; i++){
            int cur = ((config & (1 << (4 - i))) > 0? 1 : 0);
            if (cur == target){
                majority[j++] = i;
            }
        }

        // Calculate all the scores. 2 new elements each time
        int minority = -1;
        for (int i = 5; i < n - 1; i+=2){
            int m = reader.query(majority[0], majority[1], i, i + 1);
            if (m == 0){
                score -= 2;
                minority = i;
            }else if (m == 4){
                score += 2;
            }
        }
        // If n is even, then the last element wasn't accouted for above.
        if (n % 2 == 0){
            int m = reader.query(majority[0], majority[1], majority[2], n - 1);
            score += m == 4? 1 : -1;
        }

        // Finally we return the answer.
        if (score == 0)
            return -1;
        return score > 0? majority[0] : minority;
    }
}
