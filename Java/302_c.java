class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int sz = nums[0].length();
        int[] ans = new int[queries.length];
        Item[] items = new Item[nums.length];
        for (int i = 0; i < nums.length; i++){
            items[i]=new Item(i, nums[i]);
        }
        for (int i = 0; i < queries.length; i++){
            int aa = queries[i][0]-1;
            int bb = queries[i][1];
            Arrays.sort(items, (a,b) -> {
                int res = a.s.substring(sz-bb).compareTo(b.s.substring(sz-bb));
                if (res==0){
                    return a.idx-b.idx;
                }else{
                    return res;
                }
            });
            ans[i]=items[aa].idx;
        }
        return ans;
    }

    private class Item {
        String s;
        int idx;
        Item (int idx, String s){
            this.idx=idx;
            this.s=s;
        }
    }
}
