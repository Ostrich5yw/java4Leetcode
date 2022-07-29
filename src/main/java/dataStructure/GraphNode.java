package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    // Definition for a Node.
        public int val;
        public List<GraphNode> neighbors;
        public GraphNode() {
            val = 0;
            neighbors = new ArrayList<GraphNode>();
        }
        public GraphNode(int _val) {
            val = _val;
            neighbors = new ArrayList<GraphNode>();
        }
        public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
}
