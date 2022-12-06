/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        vector<double> ans;
        while(!q.empty()){
            long long sum = 0, j = size(q);
            for (int sz = size(q); sz; --sz){
                TreeNode* cur = q.front();
                q.pop();
                sum += cur->val;
                if (cur->left){
                    q.push(cur->left);
                }
                if (cur->right){
                    q.push(cur->right);
                }
            }
            ans.push_back(1.*sum/j);
        }
        return ans;
    }
};
