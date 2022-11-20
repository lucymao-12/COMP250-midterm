public class BinarySearchTree {
    BSTNode root;
    static class BSTNode {
        int key;
        BSTNode left;
        BSTNode right;
        public BSTNode(int key){
            this.key = key;
        }
    }
    public BSTNode find(BSTNode root, int key){
        if(root == null){
            return null;
        }else if(root.key == key){
            return root;
        }else if(key < root.key){
            return find(root.left, key);
        }else{
            return find(root.right, key);
        }
    }
    public BSTNode findMin(BSTNode root){
        if(root == null){
            return null;
        }else if(root.left == null){
            return root;
        }else{
            return findMin(root.left);
        }
    }
    public BSTNode findMax(BSTNode root){
        if(root == null){
            return null;
        }else if(root.right == null){
            return root;
        }else{
            return findMax(root.right);
        }
    }

    public BSTNode add(BSTNode root, int key){
        if(root == null){
            root = new BSTNode(key);
        }else if(key < root.key){
            root.left = add(root.left, key);
        }else if(key > root.key){
            root.right = add(root.right, key);
        }
        return root;
    }

    public BSTNode remove(BSTNode root, int key){
        if(root == null){
            return null;
        }else if(key < root.key){
            root.left = remove(root.left, key);
        }else if(key > root.key){
            root.right = remove(root.right, key);
        }else if(root.left == null){
            root = root.right;
        }else if(root.right == null){
            root = root.left;
        }else{
            root.key = findMin(root.right).key;
            root.right = remove(root.right, root.key);
        }
        return root;
    }
}
