https://leetcode.com/problems/faulty-sensor/discuss/1642343/Java-Simple-Solution-0ms-Explained.
class Solution {
    public int badSensor(int[] o, int[] t) {
        boolean one = canShift(o, t);
        boolean two = canShift(t, o);
        if (one == two) return -1;
        return one? 1 : 2;
    }

    private static boolean canShift(int[] o, int[] t){
        int i = 0, j = 0;
        while(j < o.length){
            if (o[i] != t[j]) j++;
            else {i++; j++;}
        }

        return i == o.length - 1;
    }
}
