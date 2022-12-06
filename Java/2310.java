class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        int sz = 1;
        while(sz<11&&k*sz%10!=num%10){
            sz++;
        }
        return sz==11 || k*sz>num? -1 : sz;
    }
}
