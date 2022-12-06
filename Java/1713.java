class Solution {
    public int minOperations(int[] T, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : T){
            map.put(n, map.size());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i])){
                continue;
            }
            int j = map.get(arr[i]);
            if (list.isEmpty()||j>list.get(list.size()-1)){
                list.add(j);
            }else{
                int lo = 0, hi = list.size()-1;
                while(lo<hi){
                    int mid=(lo+hi)>>1;
                    if (list.get(mid)>=j){
                        hi=mid;
                    }else{
                        lo=mid+1;
                    }
                }
                list.set(lo,j);
            }
        }
        return T.length-list.size();
    }
}
