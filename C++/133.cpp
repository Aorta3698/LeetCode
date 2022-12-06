
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    map<Node*, Node*> mp;
    Node* cloneGraph(Node* node) {
        if (!node || mp.count(node)){
            return mp[node];
        }
        Node* cur = new Node(node->val);
        mp[node] = cur;
        for (auto next : node->neighbors){
            cur->neighbors.push_back(cloneGraph(next));
        }
        return cur;
    }
};
