package Exp6;

import java.util.*;

class Graph {
    private int V;
    private List<List<int[]>> adj;
    private List<Edge> edges;

    public Graph(int vertices) {
        this.V = vertices;
        adj = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new int[]{v, weight});
        adj.get(v).add(new int[]{u, weight});
        edges.add(new Edge(u, v, weight));
    }

    public void primMST() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[V];
        pq.add(new int[]{0, 0});
        int mstCost = 0;
        List<int[]> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0], weight = edge[1];

            if (visited[u]) continue;
            visited[u] = true;
            mstCost += weight;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (!visited[v]) {
                    pq.add(new int[]{v, w});
                    mstEdges.add(new int[]{u, v, w});
                    System.out.println(pq);
                }
            }
        }

        System.out.println("Minimum Spanning Tree Cost (Prim's): " + mstCost);
        System.out.println("Edges in MST (Prim's):");
        for (int[] e : mstEdges)
            System.out.println(e[0] + " - " + e[1] + " : " + e[2]);
    }

    public void kruskalMST() {
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();
        int mstCost = 0;

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                mst.add(edge);
                ds.union(edge.src, edge.dest);
                mstCost += edge.weight;
            }
            if (mst.size() == V - 1) break;
        }

        System.out.println("Minimum Spanning Tree Cost (Kruskal's): " + mstCost);
        System.out.println("Edges in MST (Kruskal's):");
        for (Edge edge : mst)
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST();
        g.kruskalMST();
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}