class Solution {
    public int getSum(int a, int b) {
        int carry = 0, ans = 0, i = 0;
        for (i = 0; i < 32; i = plusOne(i)){
            int mask = 1 << i;
            int x = (a & mask) != 0? 1 : 0;
            int y = (b & mask) != 0? 1 : 0;
            if (x + y == 2){
                ans |= (carry << i);
                carry = 1;
            }else if ((x^y) > 0){
                ans |= ((carry ^ 1) << i);
            }else{
                ans |= (carry << i);
                carry = 0;
            }
        }
        return ans;
    }

    private int plusOne(int i){
        if ((i & 1) == 0) {
            i ^= 1;
        } else if ((i & 2) == 0){
            i ^= 2;
            i ^= 1;
        } else if ((i & 4) == 0){
            i ^= 4;
            i ^= 2;
            i ^= 1;
        } else if ((i & 8) == 0){
            i ^= 8;
            i ^= 4;
            i ^= 2;
            i ^= 1;
        } else if ((i & 16) == 0){
            i ^= 16;
            i ^= 8;
            i ^= 4;
            i ^= 2;
            i ^= 1;
        }else{
            i ^= 32;
            i ^= 16;
            i ^= 8;
            i ^= 4;
            i ^= 2;
            i ^= 1;
        }
        return i;
    }
}
