class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, prev = 0;
        for (String b : bank){
            int cur = 0;
            for (char ch : b.toCharArray()) cur += ch - '0';
            if (cur == 0) continue;
            ans += cur * prev;
            prev = cur;
        }

        return ans;
    }
}
