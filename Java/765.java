https://leetcode.com/problems/couples-holding-hands/discuss/2180230/Java-or-Greedy-or-Explained
class Solution {
    public int minSwapsCouples(int[] row) {
        int[] where = new int[row.length];
        for (int i = 0; i < row.length; i++){
            where[row[i]]=i;
        }
        int ans = 0;
        for (int i = 0; i < row.length; i+=2){
            int love = row[i+1]^1;
            if (row[i]!=love){
                int chosen = row[i];
                swap(i, where[love], row);
                swap(chosen, love, where);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

// class Solution {
//     public int minSwapsCouples(int[] row) {
//         int[] where = new int[row.length];
//         for (int i = 0; i < row.length; i++){
//             where[row[i]]=i;
//         }
//         return solve(0, row, where);
//     }

//     private int solve(int i, int[] row, int[] where){
//         if (i == row.length)
//             return 0;

//         int love = who(row[i+1]);
//         if (love==row[i])
//             return solve(i+2, row, where);

//         int chosen = row[i];
//         swap(i, where[love], row);
//         swap(chosen, love, where);
//         int ans = solve(i+2, row, where);
//         swap(i, where[chosen], row);
//         swap(chosen, love, where);

//         // int chosen = row[i+1];
//         // swap(i+1, where[love], row);
//         // swap(chosen, love, where);
//         // int ans = solve(i+2, row, where);
//         // swap(i+1, where[chosen], row);
//         // swap(chosen, love, where);

//         return ans+1;
//     }

//     private int who(int n){
//         return n % 2 == 0? n + 1 : n - 1;
//     }

//     private void swap(int i, int j, int[] arr){
//         int tmp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = tmp;
//     }
// }
