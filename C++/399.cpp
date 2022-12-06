https://leetcode.com/problems/evaluate-division/discuss/2526825/C%2B%2B-or-Union-Find-By-Rank-%2B-Path-Compression-or-with-comments
class Solution {
public:
    class UF {
    public:
        vector<int> parent, rank;
        vector<double> weight;
        int N;
        UF (int n) : N{n}, parent(n), rank(n), weight(n){
            iota(begin(parent), end(parent), 0); // parent init
            fill(begin(weight), end(weight), 1); // weight init -> 1
        }

        int find(int x){
            weight[x] *= weight[parent[x]]; // get the multiplier from its old parent
            return x == parent[x]? x : (parent[x] = find(parent[x])); // now update it to new parent
        }

        void unite(int x, int y, double w){
            int xr = find(x);
            int yr = find(y);
            if (xr == yr){ // already connected, no need to modify relateive weight
                return;
            }
            if (rank[yr] > rank[xr]){ // we will make xr the root, swap all.
                swap(xr, yr);
                swap(x, y);
                w = 1/w;
            }
            if (rank[xr] == rank[yr]){ // increment rank if the same
                ++rank[xr];
            }
            parent[yr] = xr; // make xr the root.
            weight[yr] = weight[x]/weight[y]*1/w; // and put the multiplier into yr old root (now child of xr)
        }

        double getW(int x, int y){ // get the weight of x/y
            return x==0||y==0||find(x)!=find(y)?-1:weight[x] / weight[y];
        }
    };
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        vector<double> ans;
        unordered_map<string, int> mp;
        mp[""]=0;
        for (auto e : equations){
            mp.try_emplace(e[0], size(mp));
            mp.try_emplace(e[1], size(mp));
        }
        UF uf(size(mp));
        auto it = begin(values);
        for (auto e : equations){
            uf.unite(mp[e[0]], mp[e[1]], *it++);
        }
        for (auto q : queries){
            ans.push_back(uf.getW(mp[q[0]], mp[q[1]]));
        }
        return ans;
    }
};
