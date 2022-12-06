class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> g(n);
        for (auto e : edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<bool> seen(n);
        int ans = 0;
        function<void(int)> dfs = [&](int cur){
            if (seen[cur]){
                return;
            }
            seen[cur] = 1;
            for (int next : g[cur]){
                dfs(next);
            }
        };
        for (int i = 0; i < n; ++i) if (!seen[i]){
            dfs(i);
            ++ans;
        }
        return ans;
    }
};
