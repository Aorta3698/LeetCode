class Solution {
    public String numberToWords(int num) {
        String[] d = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] d_ = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] dd = new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ddd = new String[]{"Thousand", "Million", "Billion"};
        String[] all = new String[101];
        for (int i = 0; i < 9; i++){
            all[i+1]=d[i];
            all[(i+1)*10]=dd[i];
            all[i+11]=d_[i];
        }
        all[100] = "Hundred";
        String ans = "";
        int cur = 0, ten = 0;
        while(num > 0){
            if (ten > 0 && ten % 3 == 0 && num%1000 > 0){
                ans = " " + ddd[ten/3-1] + ans;
            }
            if (ten%3 == 0 && num % 100 > 10 && num % 100 < 20){
                ans = all[num%100] + ans;
                num /= 10;
                ten++;
            }else{
                cur = (int)Math.pow(10, ten%3) * (num % 10);
                if (cur > 0 && cur < 100){
                    ans = all[cur] + ans;
                }
                if (cur >= 100){
                    ans = all[cur/100] + " " + all[100] + ans;
                }
            }
            if (num > 9 && num%10 > 0){
                ans = " " + ans;
            }
            num /= 10;
            ten++;
        }
        return ans.isEmpty()? "Zero" : ans;
    }
}
