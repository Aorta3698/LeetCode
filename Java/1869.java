class Solution {
    public boolean checkZeroOnes(String s) {
        int maxzero = 0, maxone = 0, zero = 0, one = 0;
        for (char ch : s.toCharArray()){
            if (ch == '1'){
                maxzero = Math.max(zero, maxzero);
                zero = 0; one++;
            }else{
                maxone = Math.max(one, maxone);
                one = 0; zero++;
            }
        }

        return Math.max(maxone, one) > Math.max(maxzero, zero);
    }
}
