class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<bool> seen(n);
        vector<vector<int>> g(n);
        for (auto e : edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        function<bool(int, int)> dfs = [&](int cur, int parent){
            if (seen[cur]){
                return true;
            }
            seen[cur] = 1;
            for (int next : g[cur]) if (next != parent && dfs(next, cur)){
                return true;
            }
            return false;
        };
        return !dfs(0, -1) && count(begin(seen), end(seen), 1) == n;
    }
};
