class Solution {
    public int minSwaps(String s) {
        int one = 0, zero = 0;
        int oneE = 0, zeroE = 0;
        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0){
                oneE += s.charAt(i) - '0';
                zeroE += '1' - s.charAt(i);
            }
            one += s.charAt(i) - '0';
            zero += '1' - s.charAt(i);
        }

        if (Math.abs(one - zero) > 1)
            return -1;

        int oneAtOdd = oneE + (zero - zeroE) - Math.min(oneE, zero - zeroE);
        int oneAtEven = zeroE + (one - oneE) - Math.min(zeroE, (one - oneE));
        if (s.length() % 2 == 0)
            return Math.min(oneAtOdd, oneAtEven);
        return one == (s.length() + 1) / 2?
            oneAtEven : oneAtOdd;
    }
}
