https://leetcode.com/problems/minimum-cost-to-reach-city-with-discounts/discuss/2528931/A-Concise-C%2B%2B-solution-with-detailed-comments.
class Solution {
public:
    int minimumCost(int n, vector<vector<int>>& highways, int discounts) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& h : highways){
            adj[h[0]].push_back({h[1], h[2]});
            adj[h[1]].push_back({h[0], h[2]});
        }
        vector<int> minUsed(n, discounts+1);
        priority_queue<array<int, 3>, vector<array<int, 3>>, greater<>> pq;
        pq.push({0, 0, 0});
        while(!pq.empty()){
            auto [cost, used, cur] = pq.top();
            pq.pop();
            if (minUsed[cur] <= used){
                continue;
            }
            if (cur == n-1){
                return cost;
            }
            minUsed[cur] = used;
            for (auto& [next, fee] : adj[cur]){
                pq.push({cost+fee, used, next});
                pq.push({cost+fee/2, used+1, next});
            }
        }
        return -1;
    }
};
