
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DFS {
    private boolean[] visited;
    private final int n;    
    
    public DFS(int n){
        this.n = n;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
    }
    
    public int depthFirstSearch(List<Integer>[] adj){
        //count the number of connected components as well
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                dfsRecursive(adj, i);
            }
        }
    }
    
    public void dfsRecursive(List<Integer>[] adj, int x){
        //code here
    }
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //node numbers are between 0 to n-1
        
        
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        //read the input graph here
        
        DFS dfs = new DFS(n);
        int components = dfs.depthFirstSearch(adj);
        System.out.println(components);//number of connected components
    }
}
