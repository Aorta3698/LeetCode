class Solution {
    public int findComplement(int num) {
        int c = ~num;
        int n = 0;
        while(num > 0){
            num >>= 1;
            n++;
        }
        for (int i = n; i < 32; i++)
            c ^= (1 << i);

        return c;
    }
}
