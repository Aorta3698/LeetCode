https://leetcode.com/problems/maximum-binary-string-after-change/discuss/1990932/Find-the-First-Zero-and-Zero-Count-or-Java-or-Concise
class Solution {
    public String maximumBinaryString(String binary) {
        int z = 0, firstZero = (int)1e9;
        for (int i = 0; i < binary.length(); i++){
            if (binary.charAt(i) == '0'){
                firstZero = Math.min(i, firstZero);
                z++;
            }
        }
        return z < 2? binary :
            "1".repeat(firstZero + z - 1) + "0" + "1".repeat(binary.length() - z - firstZero);
    }
}
