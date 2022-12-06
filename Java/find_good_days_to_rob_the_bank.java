https://leetcode.com/problems/find-good-days-to-rob-the-bank/discuss/1626444/Java-or-No-need-to-recalculate-each-time

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int idx = time;
        boolean prev = false;
        while(idx < security.length - time){
            if (prev){
                if (security[idx] == security[idx - 1] && security[idx + time] >= security[idx - 1 + time])
                    ans.add(idx++);
                else
                    prev = false;
                continue;
            }

            boolean valid = true;
            for (int i = idx - time; i < idx; i++){
                if (security[i] < security[i + 1]){
                    idx += i + 1 - (idx - time);
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            for (int i = idx; i < idx + time; i++){
                if (security[i] > security[i + 1]){
                    idx += i + 1 - idx;
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            prev = true;
            ans.add(idx++);
        }

        return ans;
    }
}
