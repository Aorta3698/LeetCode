https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/1631287/Java-or-5-Lines-or-0ms-or-Comments!
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ans = new LinkedList<>();

        while(label > 0){
            ans.addFirst(label);
            int curStart = 1 << (int)(Math.log(label) / Math.log(2));
            label = curStart - 1 - (label - curStart) / 2;
        }

        return ans;
    }
}
