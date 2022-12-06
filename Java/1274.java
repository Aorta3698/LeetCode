/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */
https://leetcode.com/problems/number-of-ships-in-a-rectangle/discuss/2116075/Cut-it-Carefully...
class Solution {
    public int countShips(Sea sea, int[] A, int[] B) {
        int mx = (A[0]+B[0])/2;
        int my = (A[1]+B[1])/2;
        if (!sea.hasShips(A,B))
            return 0;
        if (A[0]==B[0] && A[1]==B[1])
            return 1;
        return A[0]>=B[0] && A[1]>=B[1]?
            countShips(sea, new int[]{mx, A[1]}  , new int[]{B[0], my+1})
          + countShips(sea, A                    , new int[]{mx+1, my+1})
          + countShips(sea, new int[]{mx, my}    , B                  )
          + countShips(sea, new int[]{A[0], my}, new int[]{mx+1, B[1]})
          : 0;
    }
}

// class Solution {
//     public int countShips(Sea sea, int[] A, int[] B) {
//         int mx = (A[0]+B[0])/2;
//         int my = (A[1]+B[1])/2;
//         if (!sea.hasShips(A,B))
//             return 0;
//         if (A[0]==B[0] && A[1]==B[1])
//             return 1;
//         return A[0]>=B[0] && A[1]>=B[1] && sea.hasShips(A, B)?
//             countShips(sea, new int[]{mx, A[1]}  , new int[]{B[0], my})
//           + countShips(sea, A                    , new int[]{mx+1, my})
//           + countShips(sea, new int[]{mx-1, my-1}, B                  )
//           + countShips(sea, new int[]{A[0], my-1}, new int[]{mx, B[1]})
//           : 0;
//     }
// }

// class Solution {
//     public int countShips(Sea sea, int[] A, int[] B) {
//         int mx = (A[0]+B[0])/2;
//         int my = (A[1]+B[1])/2;
//         return A[0]>=B[0] && A[1]>=B[1] && sea.hasShips(A, B)?
//             countShips(sea, new int[]{mx, A[1]}  , new int[]{B[0], my+1})
//           + countShips(sea, A                    , new int[]{mx+1, my})
//           + countShips(sea, new int[]{mx-1, my}  , B                  )
//           + countShips(sea, new int[]{A[0], my-1}, new int[]{mx, B[1]})
//           + (sea.hasShips(new int[]{mx,my}       , new int[]{mx,my})? 1 : 0)
//           : 0;
//     }
// }
