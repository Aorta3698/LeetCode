class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        Integer max1 = null, max2 = max1, min1 = max1, min2 = max1;
        boolean same = true;
        for (List<Integer> list : arrays){
            int s = list.get(0);
            int m = list.get(list.size() - 1);
            if (min1 != null && s < min1 && m > max1) same = true;
            else if (min1 != null && (s < min1 || m > max1)) same = false;

            if (min1 == null || s < min1){
                min2 = min1;
                min1 = s;
            }else if (min2 == null || s < min2) min2 = s;

            if (max1 == null || m > max1){
                max2 = max1;
                max1 = m;
            }else if (max2 == null || m > max2) max2 = m;
        }

        return same? Math.max(max1 - min2, max2 - min1) : max1 - min1;
    }
}
