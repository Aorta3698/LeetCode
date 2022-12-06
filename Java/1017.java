https://leetcode.com/problems/convert-to-base-2/discuss/1921660/A-solution-that-doesn't-use-base-2
class Solution {
    public String baseNeg2(int n) {
        int[] data = new int[32];
        int j = 0;
        while(n >= (1 << j)){
            ++j;
        }
        while(j >= 0){
            int d = n / (1 << j);
            data[j] += d;
            if (d > 0 && j % 2 == 1){
                data[j + 1]++;
            }
            n -= d * (1 << j--);
        }

        for (int i = 0; i < 30; i++){
            if (data[i] >= 2){
                if (data[i + 1] > 0){
                    data[i + 1]--;
                }else{
                    data[i + 1]++;
                    data[i + 2]++;
                }
                data[i] -= 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--){
            if (sb.length() == 0 && data[i] == 0 && i > 0)
                continue;
            sb.append(data[i]);
        }


        return sb.toString();
    }
}
