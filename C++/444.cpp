class Solution {
public:
    bool sequenceReconstruction(vector<int>& nums, vector<vector<int>>& sequences) {
        int n = size(nums)+1;
        vector<vector<int>> g(n);
        vector<int> indg(n);
        for (auto s : sequences){
            for (int i = 1; i < size(s); ++i){
                g[s[i-1]].push_back(s[i]);
                indg[s[i]]++;
            }
        }
        queue<int> q;
        for (int i = 1; i < n; ++i){
            if (indg[i] == 0){
                q.push(i);
            }
        }
        bool ok = 1;
        while(!q.empty()){
            n--;
            ok &= size(q) <= 1;
            int cur = q.front();
            q.pop();
            for (int next : g[cur]){
                if (--indg[next]==0){
                    q.push(next);
                }
            }
        }
        return n==1&&ok;
    }
};
