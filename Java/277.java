/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cur = 0;
        while(true){
            int i = cur+1;
            while(i < n && !knows(cur, i)){
                i++;
            }
            if (i == n){
                for (i = 0; i < cur; i++){
                    if (knows(cur, i) || !knows(i, cur))
                        return -1;
                }
                return cur;
            }
            cur = i;
        }
    }
}
