class Solution {
    public int minNumberOfFrogs(String A) {
        if (A.length() % 5 > 0)
            return -1;
        String t = "croak";
        int[] count = new int[5];
        int ans = 0, frog = 0;
        for (char ch : A.toCharArray()){
            int i = t.indexOf(ch);
            count[i]++;
            if (ch == 'c'){
                ans = Math.max(ans, ++frog);
            }else if (ch == 'k'){
                frog--;
            }
            if (i > 0 && --count[i - 1] < 0)
                return -1;
        }

        return count[4] == A.length() / 5? ans : -1;
    }
}

// TREE SET SOLUTOIN (SLOW AND LENGTHY)
//
// class Solution {
//     public int minNumberOfFrogs(String A) {
//         if (A.length() % 5 > 0)
//             return -1;
//         String t = "croak";
//         TreeSet[] arr = new TreeSet[5];
//         Arrays.setAll(arr, o -> new TreeSet<>());
//         for (int i = 0; i < A.length(); i++){
//             int idx = t.indexOf(A.charAt(i));
//             if (idx == -1)
//                 return -1;
//             arr[idx].add(i);
//         }
//         int j = 0, cur = -1, ans = 0, tmp = 0;
//         while(true){
//             Integer next = (Integer)arr[j % 5].higher(cur);
//             if (next == null){
//                 if (j % 5 != 0)
//                     return -1;
//                 if (tmp == j)
//                     return j == A.length()?
//                         ans : -1;
//                 tmp = j;
//                 ans++;
//                 cur = -1;
//                 continue;
//             }else{
//                 cur = next;
//                 arr[j % 5].remove(cur);
//                 j++;
//             }
//         }
//     }
// }
