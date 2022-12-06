class Solution {
    private int goodPath(TreeNode root){
        return dfs(root, 1, new HashMap<>());
    }

    private int dfs(TreeNode root, int depth, Map<Integer, Integer> map){
        if (root==null || map.size()==2&&!map.containsKey(root.val)){
            return 0;
        }
        map.merge(root.val, 1, Integer::sum);
        int ans = map.size()==2&&2*map.get(root.val)==depth || map.size()==1? 1:0;
        for (TreeNode next : root.children){
            ans+=dfs(next, depth+1, map);
        }
        if (map.merge(root.val, -1, Integer::sum)==0){
            map.remove(root.val);
        }
        return ans;
    }
}
