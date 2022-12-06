class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer, Item> map = new HashMap<>();
        for (int[] a : artifacts){
            Item item = new Item((a[2] - a[0] + 1) * (a[3] - a[1] + 1));
            for (int x = a[0]; x <= a[2]; x++){
                for (int y = a[1]; y <= a[3]; y++){
                    map.put(x * n + y, item);
                }
            }
        }

        int ans = 0;
        for (int[] d : dig){
            int p = d[0] * n + d[1];
            if (!map.containsKey(p)) continue;
            if (--map.get(p).val == 0){
                ans++;
            }
        }

        return ans;
    }

    private class Item{
        int val;
        Item(int val){
            this.val = val;
        }
    }
}
