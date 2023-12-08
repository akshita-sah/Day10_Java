class MyBinaryNode
{
    MyBinaryNode left;
    MyBinaryNode right;
    int val;
    MyBinaryNode(int value)
    {
        val = value;
        left = null;
        right = null;
    }
}
public class BST {
    MyBinaryNode root;
    BST()
    {
        root = null;
    }

    /* For adding a value in bst, first we check if node is null then we assign current node as root.
    If not we traverse till the end of link of root and attach the current node.
     */
    void addValue(int value)
    {
        MyBinaryNode newNode = new MyBinaryNode(value);
        if(root == null)
        {
            root = newNode;
            return;
        }
        MyBinaryNode temp = root;
        MyBinaryNode prev = null;
        while(temp!=null)
        {
            if(value<temp.val)
            {
                prev = temp;
                temp = temp.left;
            }
            else
            {
                prev = temp;
                temp = temp.right;
            }
        }
        if(prev.val>value)
        {
            prev.left = newNode;
        }
        else
        {
            prev.right = newNode;
        }
    }

    int size(MyBinaryNode temp)
    {
        if(temp==null)
            return 0;
        return 1 + size(temp.left) + size(temp.right);
    }

    MyBinaryNode search(int value,MyBinaryNode temp)
    {
        if(temp == null || temp.val == value)
            return temp;
        if (temp.val < value)
        {
            return search(value,temp.right);
        }
        return search(value,temp.right);
    }

    /* Inorder traversal of BST always gives the nodes in sorted order */
    void displayInorder(MyBinaryNode temp)
    {
        if(temp==null)
            return;
        displayInorder(temp.left);
        System.out.print(temp.val+" ");
        displayInorder(temp.right);
    }

    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.addValue(56);
        bst.addValue(30);
        bst.addValue(70);
        bst.displayInorder(bst.root);
        System.out.println();
        System.out.println("The size of the BST is: "+bst.size(bst.root));
        MyBinaryNode searchValue = bst.search(63,bst.root);
        if(searchValue != null)
            System.out.println("The value is found in the BST");
        else
            System.out.println("The value is not present in BST");
    }
}
