class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& A) {
        /* vector<int> mp[numCourses]; */
        vector<vector<int>> mp(numCourses);
        vector<int> indg(numCourses);
        for (auto v : A){
            mp[v[1]].push_back(v[0]);
            ++indg[v[0]];
        }
        queue<int> q;
        for (int i = 0; i < numCourses; ++i){
            if (indg[i] == 0){
                q.push(i);
            }
        }
        while(!q.empty()){
            --numCourses;
            int cur = q.front();
            q.pop();
            for (int next : mp[cur]){
                if (--indg[next] == 0){
                    q.push(next);
                }
            }
        }
        return numCourses == 0;
    }
};
