https://leetcode.com/problems/ip-to-cidr/discuss/2013049/Simple-Greedy-Solution-or-Java
class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long cur = 0;
        String[] all = ip.split("\\.");
        for (int i = 0; i < all.length; i++){
            cur += Long.parseLong(all[i]) << (24 - 8 * i);
        }
        List<String> ans = new ArrayList<>();
        long end = cur + n;
        while(cur < end){
            for (int i = 9; i >= 0; i--){
                if (cur % (1 << i) == 0 && cur + (1 << i) <= end){
                    String s = "";
                    long tmp = cur;
                    for (int j = 0; j < 4; j++){
                        s += tmp >> 24 - 8 * j;
                        tmp %= 1 << 24 - 8 * j;
                        if (j < 3){
                            s += ".";
                        }
                    }
                    ans.add(s+"/"+(32-i));
                    cur += 1 << i;
                    break;
                }
            }
        }
        return ans;
    }
}
