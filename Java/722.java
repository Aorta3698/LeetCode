https://leetcode.com/problems/remove-comments/discuss/1954768/Java-Clean-Code
class Solution {
    final int SLASH= 1;
    final int BLOCK= 2;
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean comment = false;

        for (String s : source){
            int cur = blockEnd(s, 0, comment);
            if (cur == -1)
                continue;
            comment = false;
            int slash, block, chosen;
            do{
                slash = s.indexOf("//", cur);
                block = s.indexOf("/*", cur);
                chosen = selected(slash, block);
                int end = switch(chosen){
                    case SLASH: yield slash;
                    case BLOCK: yield block;
                    default: yield s.length();
                };
                sb.append(s.substring(cur, end));
                if (chosen == BLOCK){
                    cur = blockEnd(s, block + 2, true);
                    comment = cur == -1;
                }
            }while(!comment && chosen == BLOCK);

            if (!sb.isEmpty() && !comment){
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }

        return ans;
    }

    private int blockEnd(String s, int st, boolean block){
        if (!block)
            return st;
        int end = s.indexOf("*/", st);
        return end == -1? -1 : end + 2;
    }

    private int selected(int slash, int block){
        if (block > -1 && (slash == -1 || block < slash))
            return BLOCK;
        if (slash > -1 && (block == -1 || slash < block))
            return SLASH;
        return 0;
    }
}
