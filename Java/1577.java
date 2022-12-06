class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return solve(nums1, nums2) + solve(nums2, nums1);
    }

    private int solve(int[] one, int[] two){
        Map<Long, Integer> map = new HashMap<>();
        for (int n : one){
            map.merge(1L * n * n, 1, Integer::sum);
        }

        int ans = 0;
        for (long key : map.keySet()){
            for (int i = 0, j = two.length - 1; i < j;){
                long cur = 1L * two[i] * two[j];
                if (key == cur){
                    int jc = 1;
                    int ic = 1;
                    if (two[i] == two[j]){
                        ans += map.get(cur) * (j - i) * (j - i + 1) / 2;
                        break;
                    }
                    while(j - 1 > i && two[j - 1] == two[j]){
                        j--;
                        jc++;
                    }
                    while(i + 1 < j && two[i] == two[i + 1]){
                        i++;
                        ic++;
                    }
                    ans += map.get(cur) * jc * ic;
                    i++;
                    j--;
                }else if (cur > key){
                    j--;
                }else{
                    i++;
                }
            }
        }

        return ans;
    }
}
