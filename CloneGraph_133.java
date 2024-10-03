import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {
    HashMap<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        // If the node was already visited before.
        if (visited.containsKey(node)) return visited.get(node); // Return the clone form the visited dictionary.

        // create a clone for the given node.
        Node cloneNode = new Node(node.val, new ArrayList<>()); // Note that we don't have cloned neighbors as of now, hence [].

        visited.put(node, cloneNode); // the key is original node and value being the clone node.

        // Iterate through the neighbors to generate their clones
        for (Node neighbor : node.neighbors) { // and prepare a list of cloned neighbors to be added to the clone node.
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

}























