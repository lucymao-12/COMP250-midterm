public class BinaryTree<T> {
    BTNode<T> root;

    public BinaryTree(){

    }
    /**
    public static boolean isIsomorphic(BTNode n1, BTNode n2){
        if(n1.element == (n2.element) && n1.leftChild == null && n1.rightChild == null
        && n2.leftChild == null && n2.rightChild == null){
            return true;
        }else{

        }
    }
     */
    public int addTarget(int target){
        //BTNode curr = this.root;
        int[] allSum = addTargPostOrderHelper(this.root);
        int counter = 0;
        for(int i = 0; i < allSum.length; i++){
            if(allSum[i] == target){
                counter++;
            }
        }
        return counter;
    }
    public static int[] addTargPostOrderHelper(BTNode root){
        if(root != null){
            int[] leftS = addTargPostOrderHelper(root.leftChild);
            int[] rightS = addTargPostOrderHelper(root.rightChild);
            int[] returnS;
            if(root.leftChild == null && root.rightChild == null){
                returnS = new int[1];
                returnS[0] = (Integer)(root.element);
            }else {
                returnS = new int[leftS.length + rightS.length];
                System.arraycopy(leftS, 0, returnS, 0, leftS.length);
                System.arraycopy(rightS, 0, returnS, leftS.length, rightS.length);
                for (int i = 0; i < returnS.length; i++) {
                    returnS[i] += (Integer) root.element;
                }
            }
            return returnS;
        }
        int[] none = {};
        return none;
    }
}
class BTNode<T>{
    T element;
    BTNode<T> leftChild;
    BTNode<T> rightChild;

    public BTNode(T element, BTNode<T> leftChild, BTNode<T> rightChild){

    }
}