https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/2526933/A-short-C%2B%2B-Solution-(DFS)-or-Comments
class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ans;
        unordered_map<int, vector<pair<int, int>>> mp;
        function<int(int, int, TreeNode*)> dfs = [&](int x, int y, TreeNode* cur){
            if (!cur) return x;
            mp[x].push_back({y, cur->val});
            return min(dfs(x-1, y+1, cur->left), dfs(x+1, y+1, cur->right));
        };
        for (int i = dfs(0, 0, root)+1; mp.count(i); ++i){
            ans.push_back(vector<int>());
            sort(begin(mp[i]), end(mp[i]));
            transform(begin(mp[i]), end(mp[i]), back_inserter(ans.back()), [](auto& p){return p.second;});
        }
        return ans;
    }
};
