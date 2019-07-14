public class BinarySearchTree{
    private TreeNode root = new TreeNode();

    public TreeNode insertKey(TreeNode root, char x){
        TreeNode p = root;
        TreeNode newNode = new TreeNode(x);

        if(p == null){
            return newNode;
        }else if(p.data > newNode.data){
            p.left = insertKey(p.left, x);
            return p;
        }else if(p.data < newNode.data){
            p.right = insertKey(p.right, x);
            return p;
        }else {
            return p;
        }
    }

    public void insertBST(char x){
        root = insertKey(root, x);
    }

    public TreeNode searchBST(char x){
        TreeNode p = root;
        while(p != null){
            if(x < p.data) p = p.left;
            else if(x > p.data) p = p.right;
            else return p;
        }
        return p;
    }

    public void inorder(TreeNode root){
        // System.out.println(root);
        if(root != null){
            inorder (root.left);
            System.out.print(root.data + "");
            inorder(root.right);
        }
    }

    public void printBST(){
        System.out.println("print start BST");
        inorder(root);
        System.out.println("print end BST");
    }

}