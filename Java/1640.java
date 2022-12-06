class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) map.put(p[0], p);
        int idx = 0;
        while(idx < arr.length){
            if (!map.containsKey(arr[idx])) return false;
            int[] cur = map.get(arr[idx]);
            for (int i = 0; i < cur.length; i++, idx++)
                if (cur[i] != arr[idx])
                    return false;
        }

        return true;
    }
}
