class Solution {
    public double angleClock(int hour, int minutes) {
        //1 min -> 6 degree for the minute bar
        //1 min -> 360/12/60 = 0.5 degree for the hour bar
        if (hour == 12) hour = 0;
        double hourDeg = 30 * hour + 0.5 * minutes;
        double minDeg = 6 * minutes;
        double max = Math.max(hourDeg, minDeg), min = Math.min(hourDeg, minDeg);
        return Math.min(max - min, 180 - (max - min));
    }
}
