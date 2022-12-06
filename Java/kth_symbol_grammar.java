class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;

        int parent = (k+1)/2;
        if (kthGrammar(n-1, parent) == 0){
            return 2*parent == k? 1 : 0;
        }else
            return 2*parent == k? 0 : 1;


        // String s = "0";
        // for (int i = 1; i < n; i++){
        //     StringBuilder sb = new StringBuilder();
        //     for (int j = 0; j < s.length(); j++){
        //         if(s.charAt(j) == '0')
        //             sb.append("01");
        //         else
        //             sb.append("10");
        //     }
        //     s = sb.toString();
        // }

        // return s.charAt(k-1)-'0';



        // return helper(n).charAt(k-1)-'0';
    }

    // private String helper(int n){
    //     if (n == 1) return "0";

    //     String s = helper(n-1);
    //     StringBuilder sb = new StringBuilder();
    //     for (char ch : s.toCharArray()){
    //         if (ch == '0') sb.append("01");
    //         else sb.append("10");
    //     }

    //     return sb.toString();
    // }
}
