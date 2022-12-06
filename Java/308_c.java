class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        for (char t : "GMP".toCharArray()){
            int cur = 0, time = 0;
            for (int i = 0; i < garbage.length; i++){
                int count = 0;
                for (char ch : garbage[i].toCharArray()){
                    if (t == ch){
                        count++;
                    }
                }
                if (count > 0){
                    cur += time + count;
                    time = 0;
                }
                if (i < garbage.length-1){
                    time += travel[i];
                }
            }
            ans += cur;
        }
        return ans;
    }
}
