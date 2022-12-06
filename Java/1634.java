/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;

 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null) return poly2;
        if (poly2 == null) return poly1;

        PolyNode dummy = new PolyNode(0, 0, poly1);
        TreeMap<Integer, PolyNode> map = new TreeMap<>(Map.of(Integer.MAX_VALUE, dummy));
        while (poly1 != null){
            map.put(poly1.power, poly1);
            poly1 = poly1.next;
        }

        while (poly2 != null){
            int p = poly2.power;
            int sum = poly2.coefficient + (map.containsKey(p)? map.get(p).coefficient : 0);
            Integer key = map.floorKey(p - 1);
            PolyNode hi = map.get(map.ceilingKey(p + 1));
            PolyNode lo = key == null? null : map.get(key);

            if (sum == 0){
                hi.next = lo;
                map.remove(p);
            }else{
                PolyNode node = new PolyNode(sum, p, lo);
                hi.next = node;
                map.put(p, node);
            }

            poly2 = poly2.next;
        }

        return dummy.next;
    }
}
