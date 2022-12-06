class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0;
        int r = 0;
        for (char ch : moves.toCharArray()){
            u = switch(ch){
                case 'U' : yield ++u;
                case 'D' : yield --u;
                default: yield u;
            };

            r = switch(ch){
                case 'R' : yield ++r;
                case 'L' : yield --r;
                default: yield r;
            };
        }

        return u == 0 && r == 0;
    }
}
