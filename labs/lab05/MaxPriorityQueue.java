
import java.util.Scanner;

public class MaxPriorityQueue {
    
    private int heapSize;
    int[] A;

    public MaxPriorityQueue(int initialCapacity) {
        heapSize = 0;
        A = new int[initialCapacity];
    }
    
    private int left(int i){
        return 2*i + 1;
    }
    
    private int right(int i){
        return 2*i + 2;
    }
    
    private int parent(int i){
        return (i-1)/2;
    }
    
    private void maxHeapify(int i){
        int l = left(i);
        int r = right(i);
        
        int largest;
        
        if(l < heapSize && A[l] > A[i]){
            largest = l;
        }
        else{
            largest = i;
        }
        
        if(r < heapSize && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(largest);
        }
    }
    
    //public interfaces
    public boolean isEmpty(){
        return heapSize == 0;
    }
    
    public int extractMax(){
        if(heapSize == 0)
            return -1;
        int max = A[0];
        A[0] = A[heapSize - 1];
        heapSize--;
        maxHeapify(0);
        return max;
    }
    
    public void insert(int key){
        heapSize++;
        A[heapSize - 1] = Integer.MIN_VALUE; // instead of minus infinity
        increaseKey(heapSize - 1, key);
    }
    
    public void increaseKey(int i, int key){
        if(key > A[i]){//increase
            A[i] = key;
            while(i > 0 && A[parent(i)] < A[i]){
                int temp = A[i];
                A[i] = A[parent(i)];
                A[parent(i)] = temp;
                i = parent(i);
            }
        }
    }
    
    public int height(int i){//height of any subtree
        int leftChild = left(i);
        int rightChild = right(i);
        
        if(leftChild >= heapSize){//a leaf
            return 0;
        }
        
        int height = 1 + height(leftChild);
        if(rightChild < heapSize)
            height = Math.max(height, 1 + height(rightChild));
        
        return height;
    }
    
    public int subtreeSize(int i){
        return 0;
    }
    
    
    public static void main(String[] args){
        
        MaxPriorityQueue pq = new MaxPriorityQueue(1000);
        
        int[] arr = {5, 4, 1, 2, 7, 8, 6, 3};
        
        for(int i = 0; i < arr.length; i++)
            pq.insert(arr[i]);
        
        /*
        The result of insertion in this order is the following heap:
        
                        8
                   5         7
                3     4   1      6
            2
        
        */
        
        while(!pq.isEmpty()){
            System.out.println("tree height= " + pq.height(0));
            int x = pq.extractMax();
            System.out.println("max= " + x);
        }
    }
}
