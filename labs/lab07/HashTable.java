

public class HashTable {
    private final Integer[] table;
    private final int M; //table size
    private final int P;
    private final int W = 16; //word size
    private final double GoldenRatio = (Math.sqrt(5) - 1.0)/2.0;
    private final int S = (int)(GoldenRatio * (1 << W));
    private final int DELETED = -1;
    
    public HashTable(int P) {
        this.P = P;
        M = (1 << P);
        table = new Integer[M];
    }
    
    //hash function using multiplication method,
    //it hashes the keys to range [0, 2^p)
    private int hPrime(int key){
        return ((key*S)%(1<<W))>>(W-P);
    }
    
    private int h(int key, int i){//code here, use linear probing
    }
    
    public void insert(int key){ //code here
        
    }
    
    public Integer search(int key){
        int i = 0;
        int j;
        do{
            //we don't need to handle the DELETED case separately
            j = h(key, i);
            if(table[j] == null){
                return null;
            }
            else if(table[j] == key){
                return j;
            }
            i++;
        }while(i < M);
        return null;
    }
    
    public void delete(int key){ //code here
        
    }
    
    public static void main(String[] args){
        
        int[] keys = {99, 88, 78, 43, 57, 34, 69, 23, 25, 93, 13, 8, 71};//13
        
        /*
         find the first p such 2^p >= m
         */
        
        HashTable table = new HashTable(4); //size of 2^4=16
        
        for(int i = 0; i < keys.length; i++){
            table.insert(keys[i]);
        }
        
        for(int i = 0; i < keys.length; i++){
            Integer index = table.search(keys[i]);
            System.out.println(keys[i] +
                               (index == null ? " not found" : " found at " + index));
        }
        
        table.delete(88);
        table.delete(78);
        table.delete(93);
        table.insert(93);
        
        System.out.println("====================");
        
        for(int i = 0; i < keys.length; i++){
            Integer index = table.search(keys[i]);
            System.out.println(keys[i] +
                               (index == null ? " not found" : " found at " + index));
        }
    }
}
