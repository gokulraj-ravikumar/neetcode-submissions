class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

    
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                count++;
            }
        }

        return count;

    }

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if(parent[x] != x)
                parent[x] = find(parent[x]);  // path compression
            return parent[x];
        }

        public void union(int x, int y) {

            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] < rank[py]) {
                parent[px] = py;
            } else if(rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    
}

