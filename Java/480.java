https://leetcode.com/problems/sliding-window-median/discuss/2228979/Java-or-Adjust-Median-on-the-fly-or-NlogK-or-1-TreeSet
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> cmp = Comparator.<Integer>comparingInt(o -> nums[o]).thenComparing(o -> o);
        TreeSet<Integer> set = new TreeSet<>(cmp);
        double[] ans = new double[nums.length - k + 1];
        int median = 0;
        for (int i = 0, dir=-k%2; i < k; i++, dir%=2){
            set.add(i);
            dir += nums[i]>=nums[median]?1:-1;
            median = updateMedian(dir, median, set);
        }
        for (int i = k; i <= nums.length; i++){
            ans[i-k]=k%2==1?1d*nums[median]:(1d*nums[median]+nums[set.lower(median)])/2;
            if (i<nums.length){
                set.add(i);
                set.remove(i-k);
                int dir = nums[i]>=nums[median]? 1 : -1;
                if (nums[i-k]==nums[median] && i-k==median){
                    dir += dir;
                }else{
                    dir += nums[i-k]<=nums[median]?  1 : -1;
                }
                median = updateMedian(dir, median, set);
            }
        }
        return ans;
    }

    private int updateMedian(int dir, int median, TreeSet<Integer> set){
        return switch(dir){
            case  2: yield set.higher(median);
            case -2: yield set.lower(median);
            default: yield median;
        };
    }
}

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> cmp = Comparator.<Integer>comparingInt(o -> nums[o]).thenComparing(o -> o);
        TreeSet<Integer> set = new TreeSet<>(cmp);
        double[] ans = new double[nums.length - k + 1];
        int median = 0;
        for (int i = 0, dir=k&1; i < k; i++, dir%=2){
            set.add(i);
            dir += nums[i]>=nums[median]?1:-1;
            median = updateMedian(dir, median, set);
        }
        for (int i = k; i <= nums.length; i++){
            ans[i-k]=k%2==1?1d*nums[median]:(1d*nums[median]+nums[set.higher(median)])/2;
            if (i<nums.length){
                set.add(i);
                set.remove(i-k);
                int dir = nums[i]>=nums[median]? 1 : -1;
                if (nums[i-k]==nums[median] && i-k==median){
                    dir += dir;
                }else{
                    dir += nums[i-k]<=nums[median]?  1 : -1;
                }
                median = updateMedian(dir, median, set);
            }
        }
        return ans;
    }

    private int updateMedian(int dir, int median, TreeSet<Integer> set){
        return switch(dir){
            case  2: yield set.higher(median);
            case -2: yield set.lower(median);
            default: yield median;
        };
    }
}
