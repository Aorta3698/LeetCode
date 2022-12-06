class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashMap<Integer, Integer> otherMp = new HashMap<>();
        int count = 0;

        store(mp, nums1, nums2);
        store(otherMp, nums3, nums4);

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = -entry.getKey();
            if (otherMp.containsKey(key)){
                count += entry.getValue()*otherMp.get(key);
            }
        }

        return count;
        
    }

    private void store(Map<Integer, Integer> mp, int[] a, int[] b){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                int count = mp.getOrDefault(a[i]+b[j], 0);
                mp.put(a[i]+b[j], count+1);
            }
        }
    }
}
