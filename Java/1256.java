https://leetcode.com/problems/encode-number/discuss/1651131/Java-Two-Solution-from-O(LogN)-to-O(1)
class Solution {
    public String encode(int num) {
        StringBuilder sb = new StringBuilder();
        int base = 0, numOfDigit = 0;
        while(base*2+1 <= num) {
            base = 2 * base + 1;
            numOfDigit++;
        }

        num -= base;
        while(num > 0){
            sb.append(num % 2);
            num /= 2;
            numOfDigit--;
        }
        while(numOfDigit-- > 0) sb.append('0');

        return sb.reverse().toString();
    }
}
