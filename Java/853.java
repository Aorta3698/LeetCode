https://leetcode.com/problems/car-fleet/discuss/1928437/Java-or-Sort-by-Integer
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] arr = new Car[speed.length];
        for (int i = 0; i < speed.length; i++){
            arr[i] = new Car(speed[i], position[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> -o.p));

        int cur = 0, ans = 1;
        for (int i = 1; i < arr.length; i++){
            if (1L * (target - arr[cur].p) * arr[i].s < 1L * (target - arr[i].p) * arr[cur].s){
                cur = i;
                ans++;
            }
        }

        return ans;
    }

    private class Car{
        int s;
        int p;
        Car(int s, int p){
            this.s = s;
            this.p = p;
        }
    }
}
