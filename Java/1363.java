class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int[] count = new int[3];
        int mod = 0;
        for (int n : digits){
            count[n%3]++;
            mod+=n;
        }

        mod%=3;
        StringBuilder sb = new StringBuilder();
        int p = count[mod]>0?mod:3-mod;
        int min = p==mod?1:2;
        boolean ok=false;
        for (int i = digits.length-1; i>=0;--i){
            count[digits[i]%3]--;
            if (mod==0 || count[p]>=min || digits[i]%3!=p && (ok || sb.isEmpty())){
                sb.append(digits[i]);
                ok|=digits[i]>0;
                if (!ok){
                    break;
                }
            }
        }

        return sb.toString();
    }
}
