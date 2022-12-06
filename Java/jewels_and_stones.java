class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char ch : jewels.toCharArray()){
            for (char stone : stones.toCharArray())
                if (ch == stone) count++;
        }

        return count;
    }
}
