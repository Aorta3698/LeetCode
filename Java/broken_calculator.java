class Solution {
    public int brokenCalc(int startValue, int target) {
        int step = 0;
        while(target > startValue){
            target = target % 2 == 0? target / 2 : ++target;
            step++;
        }

        return step + startValue - target;
    }
}
