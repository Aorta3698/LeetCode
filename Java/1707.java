https://leetcode.com/problems/maximum-xor-with-an-element-from-array/discuss/2284358/Java-or-Binary-Tree-or-Offline-Query-Trick
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Integer[] idx = IntStream.range(0, ans.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> queries[o][1]));
        Arrays.sort(nums);
        Node root = new Node();
        for (int i = 0,j=0; i < ans.length; i++){
            int m = queries[idx[i]][1], x = queries[idx[i]][0];
            while(j<nums.length&&nums[j]<=m){
                Node cur = root;
                for (int k =31;k>=0;k--){
                    int val = (nums[j]&1<<k)>0?1:0;
                    if (cur.bits[val]==null){
                        cur.bits[val]=new Node();
                    }
                    cur=cur.bits[val];
                }
                j++;
            }
            if (j==0){
                ans[idx[i]]=-1;
                continue;
            }
            ans[idx[i]]=x;
            Node cur = root;
            for (int k = 31; k>=0;k--){
                int val = (x&1<<k)>0?1:0;
                if (cur.bits[val^1]!=null){
                    cur=cur.bits[val^1];
                    ans[idx[i]]|=1<<k;
                }else{
                    cur=cur.bits[val];
                    ans[idx[i]]&=~(1<<k);
                }
            }
        }
        return ans;
    }

    private class Node {
        Node[] bits = new Node[2];
        Node(){}
    }
}
