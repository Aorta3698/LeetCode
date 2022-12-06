https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/2521288/C%2B%2B-or-BFS-or-with-comments
class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        vector<int> ans(9);
        iota(begin(ans), end(ans), 1);
        while(--n){
            vector<int> next;
            for (int sign : {1, -1}){
                for (int val : ans){
                    if (int d = sign*k+val%10; d>=0&&d<10){
                        next.push_back(10*val+d);
                    }
                }
                if (!k){
                    break;
                }
            }
            ans = next;
        }
        return ans;
    }
};
