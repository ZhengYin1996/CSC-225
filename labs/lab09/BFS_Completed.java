
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;


public class BFS {
    private int[] distance;
    private boolean[] visited;
    private int[] parent;
    private Queue<Integer> q;
    
    
    public BFS(int n){
        distance = new int[n];
        visited = new boolean[n];
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
        }
    }
    
    public int breadthFirstSearch(List<Integer>[] adj, int source, int target){
        distance[source] = 0;
        visited[source] = true;
        q = new ArrayDeque<>();
        
        q.add(source);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < adj[cur].size(); i++){
                int next = adj[cur].get(i);
                if(visited[next] == false){
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
        
        return distance[target];
    }
    
    public void printPath(int x){
        if(parent[x] == -1){
            System.out.print(x);
        }
        else{
            printPath(parent[x]);
            System.out.print("->" + x);
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //node numbers are between 0 to n-1
        int source = in.nextInt();
        int target = in.nextInt();
        
        
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        //reading the graph
        for(int i = 0; i < n; i++){
            int degree = in.nextInt(); //
            for(int j = 0; j < degree; j++){
                adj[i].add(in.nextInt());
            }
        }
        
        BFS bfs = new BFS(n);
        int distance = bfs.breadthFirstSearch(adj, source, target);
        System.out.println(distance);
        bfs.printPath(target);
    }
}