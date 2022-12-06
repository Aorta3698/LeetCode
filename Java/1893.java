We could avoid iterating values less than left ?

    int line[52] = {};
    for (auto &r : ranges) {
        if (r[1]<left || r[0] > right)  continue;
        line[max(r[0], left)] += 1;
        line[min(r[1]+1, right+1)] -= 1;
    }

    for (int i = left, overlaps = 0; i <= right; ++i) {
        overlaps += line[i];
        if (overlaps <= 0)
            return false;
    }

    return true;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] count = new int[52];
        int cnt = 0;
        for (int[] r : ranges){
            if (r[0] <= left) cnt++;
            else count[r[0]]++;
            if (r[1] + 1 <= left) cnt--;
            else count[r[1] + 1]--;
        }

        for (int i = left; i <= right; i++){
            cnt += count[i];
            if (cnt == 0) return false;
        }

        return true;
        // int[] start = new int[51], end = new int[52];
        // int cnt = 0;
        // for (int[] r : ranges){
        //     if (r[0] <= left) cnt++;
        //     else start[r[0]]++;
        //     if (r[1] + 1 <= left) cnt--;
        //     else end[r[1] + 1]++;
        // }

        // for (int i = left; i <= right; i++){
        //     cnt += start[i];
        //     cnt -= end[i];
        //     if (cnt == 0) return false;
        // }

        // return true;
    }
}
