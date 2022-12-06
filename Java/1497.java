class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr){
            map.merge((n % k + k) % k, 1, Integer::sum);
        }
        for (int key : map.keySet()){
            if (key == 0){
                if (map.get(key) % 2 != 0){
                    return false;
                }
            }else if (k - key == key){
                if (map.get(key) % 2 != 0){
                    return false;
                }
            }else if ((int)map.get(key) != (int)map.getOrDefault(k - key, 0)){
                return false;
            }
        }
        return true;
    }
}
