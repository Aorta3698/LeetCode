class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] reachable = new boolean[128][128];
        for (char[] m : mappings){
            reachable[m[0]][m[1]]=true;
        }
        for (int i = 0; i < 128; i++){
            reachable[i][i]=true;
        }

        for (int i = 0; i < s.length()-sub.length()+1; i++){
            for (int j = 0; j <sub.length() && reachable[sub.charAt(j)][s.charAt(i+j)]; j++){
                if (j == sub.length()-1)
                    return true;
            }
        }
        return false;
    }
}
