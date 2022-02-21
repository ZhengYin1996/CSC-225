

public class BinaryTree {
    Node root;

    BinaryTree()
    {
        root = null;
    }

    private Node insertRecur(Node current, int value)
    {
        if(current == null)
        {
            return new Node(value);
        }
        if(value < current.value)
        {
            current.left = insertRecur(current.left,value);
        }
        else if( value > current.value)
        {
            current.right = insertRecur(current.right, value);

        }
        else
        {
            return current;
        }
        return current;
    }

    public void insert(int value)
    {
        root = insertRecur(root,value);
    }

    public void inOrder(Node node)
    {
        if(node==null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }
    public void preOrder(Node node)
    {
        if(node==null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Node node)
    {
        if(node==null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.value + " ");
    }

    public static void main(String[] args)
    {
        BinaryTree BT = new BinaryTree();
        BT.insert(4);
        BT.insert(5);
        BT.insert(8);
        BT.insert(9);
        BT.insert(2);
        BT.insert(1);
        BT.insert(10);
        BT.insert(3);
        BT.insert(6);
        BT.insert(7);
        BT.inOrder(BT.root);
        System.out.println();
        BT.preOrder(BT.root);
        System.out.println();
        BT.postOrder(BT.root);
    }
}
