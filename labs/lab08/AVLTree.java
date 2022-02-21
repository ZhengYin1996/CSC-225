/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alimashreghi
 */
 class Node implements Comparable<Node>{
    Node left;
    Node right;
    Node parent;
    int key;
    int height;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
        parent = null;
        height = 0;
    } 

    @Override
    public int compareTo(Node o) {
        if(this.key < o.key) return -1;
        if(this.key > o.key) return 1;
        return 0;
    }
}

public class AVLTree {
    
    public Node root;
    
    private void transplant(Node u, Node v){
        if(u.parent == null){
            root = v;
        }
        else if(u.parent.left != null 
                && u.parent.left.compareTo(u) == 0){
            u.parent.left = v;
        }
        else{
            u.parent.right = v;
        }
        if(v != null){
            v.parent = u.parent;
        }
    }
    
    private void rotateLeft(Node x){
        //code here
    }
    
    private void rotateRight(Node x){
        //code here
    }
    
    /**
     * inserting z into a subtree rooted at x
     * assuming that x.key is a new key
     */
    private void insertRecursive(Node x, Node z){
        /*
         Do the recursive insertion
         
         */
        
        updateHeight(x);
        
        int balanceFactor = height(x.right) - height(x.left);
        
        //left-left
        if(balanceFactor < -1 && z.key < x.left.key){
            rotateRight(x);
        }
        
        //left-right
        else if(balanceFactor < -1 && z.key > x.left.key){
            //code here
        }
        
        //right-right
        else if(balanceFactor > 1 && z.key > x.right.key){
            //code here
        }
        
        //right-left
        else if(balanceFactor > 1 && z.key < x.right.key){
            //code here
        }
    }
    
    private void insert(Node z){
        if(root == null){
            root = z;
        }
        else{
            insertRecursive(root, z);
        }
    }
    
    /**
     * 
     * @return height of the node n
     */
    private int height(Node x){
        if(x == null)
            return -1;
        return x.height;
    }
    
    /**
     * updates the height of node x after an insertion 
     */
    private void updateHeight(Node x){
        x.height = 1 + Math.max(height(x.left), height(x.right));
    }
    
    public void inorderWalk(Node x){
        if(x != null){
            inorderWalk(x.left);
            System.out.print(x.key + " ");
            inorderWalk(x.right);
        }
    }
    
    public static void main(String[] args){
        /*
         transplat is provided.
         
         Task 1: Implementing recursive insertion and rotate left; this should work if the keys
         are inserted in descending order
         
         Task2: Implementing right rotate and and handling the cases left-right right-right and right-left
         
         */
        
        
        
        AVLTree avl = new AVLTree();
        
        int[] arr = {15, 10, 16, 13, 19, 14, 18};
        
        for(int i = 0; i < 100; i++){
            //int key = (int)(Math.random() * 10000);
            //avl.insert(new Node(key));
            avl.insert(new Node(100 - i));
        }
        
        avl.inorderWalk(avl.root);
        
        System.out.println("\nHeight of the tree = " + avl.root.height);
    }
    
}
