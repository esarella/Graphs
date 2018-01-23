/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
//      Definition for undirected graph.
      class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

        return cloneGraphHelper(node, map);
    }

    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node,  HashMap<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode result = map.get(node.label);
        if (result == null){
            result = new UndirectedGraphNode(node.label);
            map.put(node.label, result);
            for(UndirectedGraphNode tempNode: node.neighbors){
                result.neighbors.add(cloneGraphHelper(tempNode,map));
            }
        }
        return result;
    }
}
