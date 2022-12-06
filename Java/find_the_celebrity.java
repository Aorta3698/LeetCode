/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int po = -1;
        for (int i = 0; i < n; i++){
            boolean doesntKnow = true;
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                if (knows(i, j)) {
                    doesntKnow = false;
                    break;
                }
            }

            if (doesntKnow){
                po = i;
                break;
            }
        }

        if (po == -1) return -1;
        for (int i = 0; i < n; i++)
            if (i != po && !knows(i, po)) return -1;

        return po;
    }
}
