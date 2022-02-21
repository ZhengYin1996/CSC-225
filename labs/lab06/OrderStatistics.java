
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alimashreghi
 */
public class OrderStatistics {
    
    static void exchange(int[] A, int i, int j){//swaps A[i] and A[j]
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    /**
     * partitions the subarray A[p .. r - 1]
     * p is inclusive and r is exclusive
     *
     * @return the index of the pivot in the partitioned array
     * 
     */
    static int partition(int[] A, int p, int r){
        int x = A[r - 1];
        int i = p - 1;
        for(int j = p; j < r - 1; j++){
            if(A[j] <= x){
                i++;
                exchange(A, i, j);
            }
        }
        exchange(A, i + 1, r - 1);
        return i + 1;
    }
    
    /**
     * Uses the partition method to partition using 
     * a random element in range A[p .. r - 1]
     * 
     * To be implemented by student
     * @return the index of the pivot in the partitioned array
     */
    static int paranoidPartition(int[] A, int p, int r){
        //
    }
    
    /**
     * p is inclusive and r is exclusive
     * 
     * @return the i th smallest element in A (1 <= i <= n)
     */
    static int randomizedSelect(int[] A, int p, int r, int i){
        //first use partition to check correctness of randomizedSelect
        //then replace with paranoidPartition to get expected linear time

    }
    
    
    public static void main(String[] args){
        
        // array elements should be DISTINCT
        int arr[] = {6, 14, 3, 9, 2, 5, 11, 8, 213, 12, 99, 0, -10, -111};
        
        System.out.println("All order statistics in ascending order");
        
        for(int i = 1; i <= arr.length; i++){
            int ithSmallest = randomizedSelect(arr, 0, arr.length, i);
            System.out.print(ithSmallest + " ");
        }
                
        System.out.println("\n\nShould match the sorted array!");
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
