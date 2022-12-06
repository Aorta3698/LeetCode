class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] i : intervals){
            map.merge(i[0], 1, Integer::sum);
            map.merge(i[1], -1, Integer::sum);
        }

        int count = 0;
        for (int n : map.values()){
            count += n;
            if (count >= 2) return false;
        }

        return true;
    }
}
