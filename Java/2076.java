https://leetcode.com/problems/process-restricted-friend-requests/discuss/2176317/Java-17ms-with-BitSet-(100)
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        Group[] groups = new Group[n];
        Arrays.setAll(groups, o -> new Group(o));
        for (int[] r : restrictions){
            groups[r[0]].ban(r[1]);
            groups[r[1]].ban(r[0]);
        }

        UF uf = new UF(n);
        boolean[] ans = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++){
            ans[i] = uf.union(requests[i][0], requests[i][1], groups);
        }
        return ans;
    }

    private class Group {
        BitSet member = new BitSet();
        BitSet blacklist = new BitSet();
        Group(int n){
            member.set(n);
        }

        void ban(int n){
            blacklist.set(n);
        }

        void merge(Group other){
            member.or(other.member);
            blacklist.or(other.blacklist);
        }

        boolean canFit(Group other){
            BitSet oMember = (BitSet)other.member.clone();
            oMember.and(blacklist);
            return oMember.cardinality()==0;
        }
    }

    private class UF {
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
        }

        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        boolean union(int x, int y, Group[] groups){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot==yRoot)
                return true;
            if (!groups[xRoot].canFit(groups[yRoot]) || !groups[yRoot].canFit(groups[xRoot]))
                return false;
            if (rank[xRoot]>rank[yRoot]){
                parent[yRoot]=xRoot;
                groups[xRoot].merge(groups[yRoot]);
            }else{
                parent[xRoot]=yRoot;
                groups[yRoot].merge(groups[xRoot]);
                if (rank[xRoot]==rank[yRoot]){
                    rank[yRoot]++;
                }
            }
            return true;
        }
    }
}
