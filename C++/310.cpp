class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        vector<int> ans, indg(n);
        vector<vector<int>> g(n);
        for (auto e : edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
            ++indg[e[0]];
            ++indg[e[1]];
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) if (indg[i] == 1){
            q.push(i);
        }
        while(!q.empty()){
            ans.clear();
            for (int sz = size(q); sz > 0; --sz){
                int cur = q.front();
                q.pop();
                for (int next : g[cur]) if (--indg[next] == 1){
                    q.push(next);
                }
                ans.push_back(cur);
            }
        }
        return n==1?vector<int>{0}:ans;
    }
};
