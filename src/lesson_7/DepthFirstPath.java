package lesson_7;


public class DepthFirstPath extends Path{

    public DepthFirstPath(Graph g, int source) {
        super(g, source);
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

}
