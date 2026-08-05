import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        
        Set<Integer> suspicious = new HashSet<>();
        
        dfs(k, graph, indegree, suspicious);
        
        for (int node : suspicious) {
            if (indegree[node] > 0) {

                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) result.add(i);
        }
        return result;
    }
    
    private void dfs(int node, List<List<Integer>> graph, int[] indegree, Set<Integer> suspicious) {
        suspicious.add(node);
        for (int nei : graph.get(node)) {
            indegree[nei]--;
            if (!suspicious.contains(nei)) {
                dfs(nei, graph, indegree, suspicious);
            }
        }
    }
}
