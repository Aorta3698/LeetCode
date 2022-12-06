https://leetcode.com/problems/maximize-the-beauty-of-the-garden/discuss/2240525/Java-or-Only-the-firstandlast-matter-and-all-in-between-neg-greater-0
class Solution {
    public int maximumBeauty(int[] flowers) {
        Map<Integer, Integer> st = new HashMap<>();
        Map<Integer, Integer> end= new HashMap<>();
        int n = flowers.length;
        int[] pre = new int[n];
        for (int i=0,j=n-1;i<n;i++,--j){
            st.put(flowers[j],j);
            end.put(flowers[i],i);
            pre[i]=Math.max(flowers[i],0)+(i==0?0:pre[i-1]);
        }
        int ans = Integer.MIN_VALUE;
        for (int key : st.keySet()){
            if (!end.get(key).equals(st.get(key))){
                ans=Math.max(ans, pre[end.get(key)-1]-pre[st.get(key)]+2*key);
            }
        }
        return ans;
    }
}
