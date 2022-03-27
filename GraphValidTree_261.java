public class GraphValidTree_261 {
    class UnionFind {
        private int[] parent;

        //For efficiency, we aren't using makeset, but instead initialising
        // all the sets at the make time in the constructor.
        public UnionFind(int n) {
            parent = new int[n];
            for (int node = 0; node < n; node++) {
                 parent[node] = node;
            }
        }

        // The find method, without any optimizations, It traces up the parent
        public int find(int A) {
            while (parent[A] != A) {
                A = parent[A];
            }
            return A;
        }

        // The union method, without any optimizations. It returns Ture if a
        // merge happened, False if otherwise.
        public boolean union(int A, int B) {
            // Find the roots for A and B.
            int rootA = find(A);
            int rootB = find(B);
            if(rootA == rootB) return false;
            parent[rootA] = rootB;
            return true;
        }
    }

    class Solution {
        public boolean validTree(int n, int[][] edges) {
            // Condition 1: The graph must contain n - 1 edges.
            if(edges.length != n - 1) return false;
            // Condition 2: The graph must contain a single connected component.
            // Create a new UnionFind object with n nodes.

            UnionFind unionFind = new UnionFind(n);
            // Add each edge. Check if a merge happened, because if it
            // did't, there must be a cycle.
            for(int[] edge: edges) {
                int A = edge[0];
                int B = edge[1];
                if(!unionFind.union(A, B)) return false;
            }
            return true;
        }
    }
}
