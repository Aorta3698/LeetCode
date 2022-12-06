class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr){
            map.merge(n, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int i;
        for (i = 0; i < list.size(); i++){
            if (k < list.get(i)){
                break;
            }
            k -= list.get(i);
        }

        return map.size() - i;
    }
}
