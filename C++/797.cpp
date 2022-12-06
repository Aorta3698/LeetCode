class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int dst = (int)size(graph)-1;
        vector<vector<int>> ans;
        function<void(int, vector<int>)> solve = [&](int cur, vector<int> path){
            path.push_back(cur);
            if (cur == dst){
                ans.push_back(path);
            }else for (int next : graph[cur]){
                solve(next, path);
            }
            path.pop_back();
        };
        solve(0, vector<int>());
        return ans;
    }
};
