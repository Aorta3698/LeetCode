class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int f = 0;
        int s = 0;

        while(s < secondList.length && f < firstList.length){
            int firstFront = firstList[f][0];
            int firstEnd = firstList[f][1];
            int secondFront = secondList[s][0];
            int secondEnd = secondList[s][1];

            if (firstFront > secondEnd){
                s++;
                continue;
            }
            if (secondFront > firstEnd){
                f++;
                continue;
            }

            int[] overlap = new int[2];
            int end = Math.min(secondEnd, firstEnd);
            int start = Math.max(secondFront, firstFront);
            overlap[0] = start;
            overlap[1] = end;
            ans.add(overlap);

            if (end == secondEnd) s++;
            else f++;
        }

        return ans.toArray(new int[0][]);
    }
}
