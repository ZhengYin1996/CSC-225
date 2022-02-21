import java.util.Scanner;


public class Solution {
    
    static int mergeSortCount(int[] arr, int p, int r){
        int inversions = 0;
        if(p < r){
            int q = (p + r)/2;
            inversions += mergeSortCount(arr, p, q);
            inversions += mergeSortCount(arr, q + 1, r);
            inversions += mergeCount(arr, p, q, r);
        }
        return inversions;
    }
    
    static int mergeCount(int[] arr, int p, int q, int r){
        /* your code goes here */
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        System.out.println(mergeSortCount(arr, 0, n - 1));
    }
}
