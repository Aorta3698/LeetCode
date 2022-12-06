https://leetcode.com/problems/delete-duplicate-folders-in-system/discuss/2396155/Java-or-Concise-or-Briefly-Explained-%2B-Comments
class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        List<List<String>> ans = new ArrayList<>();
        Tree root = new Tree();
        for (List<String> p : paths){
            Tree cur = root;
            for (String f : p){
                cur.sub.putIfAbsent(f, new Tree());
                cur = cur.sub.get(f);
                cur.name = f;
            }
        }
        mark(root, new HashMap<>());
        populate(root, new ArrayList<>(), ans);
        return ans;
    }

    private String mark(Tree root, Map<String, Tree> seen){
        StringBuilder sb = new StringBuilder("T");
        for (String key : root.sub.keySet()){
            Tree next = root.sub.get(key);
            sb.append(mark(next, seen)).append("S");
        }
        if (seen.containsKey(sb.toString())){
            root.deleted=seen.get(sb.toString()).deleted=true;
        }
        if (!root.sub.isEmpty()){
            seen.put(sb.toString(), root);
        }
        sb.append("P").append(root.name);
        return sb.toString();
    }

    private void populate(Tree root, List<String> tmp, List<List<String>> ans){
        if (root.deleted){
            return;
        }
        if (!root.name.isEmpty()){
            tmp.add(root.name);
            ans.add(new ArrayList<>(tmp));
        }
        for (String key : root.sub.keySet()){
            populate(root.sub.get(key), tmp, ans);
        }
        if (!tmp.isEmpty()){
            tmp.remove(tmp.size()-1);
        }
    }

    private class Tree {
        boolean deleted;
        String name = "";
        Map<String, Tree> sub = new TreeMap<>();
        Tree(){}
    }
}
