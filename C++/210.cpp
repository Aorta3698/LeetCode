class Solution {
public:
    vector<int> findOrder(int N, vector<vector<int>>& A) {
        vector<int> ans, indg(N);
        vector<vector<int>> mp(N);
        for (auto a : A){
            mp[a[1]].push_back(a[0]);
            ++indg[a[0]];
        }
        queue<int> q;
        for (int i = 0; i < N; ++i) if (!indg[i]){
            q.push(i);
        }
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            ans.push_back(cur);
            for (int next : mp[cur]){
                if (!--indg[next]){
                    q.push(next);
                }
            }
            --N;
        }
        return N? vector<int>(0) : ans;
    }
};
