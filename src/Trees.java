import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
    TreeNode<Integer> root;
    TreeNodeFCNS<Integer> rootFCLS;
    class TreeNode<T>{
        T element;
        ArrayList<TreeNode> children;
        TreeNode<T> parent;
        public TreeNode(T element, ArrayList<TreeNode> children, TreeNode<T> parent){

        }
    }
    class TreeNodeFCNS<T>{
        T element;
        TreeNodeFCNS<T> firstChild;
        TreeNodeFCNS<T> nextSibling;
        TreeNodeFCNS<T> parent;
    }

    public static void depthFirstPRE(TreeNode<Integer> root){
        if(root.element != null){
            System.out.println(root.element);
            for(TreeNode<Integer> child : root.children){
                depthFirstPRE(child);
            }
        }
    }
    public static void depthFirstPOST(TreeNode<Integer> root){
        if(root.element != null){
            for(TreeNode<Integer> child : root.children){
                depthFirstPRE(child);
            }
            System.out.println(root.element);
        }
    }
    public static void traverseStack(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> curr;
        stack.push(root);
        while(!stack.isEmpty()){
            curr = stack.pop();
            System.out.println(curr.element);
            for(TreeNode<Integer> child : curr.children) stack.push(child);
        }
    }
    public static void traverseQ(TreeNode<Integer> root){
        MyQueue<TreeNode<Integer>> newQ = new MyQueue<TreeNode<Integer>>();
        newQ.enqueue(root);
        TreeNode<Integer> curr = root;
        while(!newQ.isEmpty()){
            curr = newQ.dequeue();
            System.out.println(curr.element);
            for(TreeNode<Integer> child : curr.children) newQ.enqueue(child);
        }
    }


    public static void main(String[] args) {
        //TreeNode<Integer> root = new TreeNode<Integer>();

    }
}

class MyQueue<E>{
    ArrayList<E> underLying = new ArrayList<E>();
    int size = underLying.size();
    E dequeue(){
        this.size--;
        return underLying.remove(0);
    }
    void enqueue(E in){
        underLying.add(in);
        this.size++;
    }
    boolean isEmpty(){
        return underLying.isEmpty();
    }
}




