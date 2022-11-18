import java.util.ArrayList;
import java.util.Queue;

public class Stack<E> {
    ArrayList<E> stack;
    ArrayList<E> min = new ArrayList<E>();
    int size;

    public Stack() {
        stack = new ArrayList<E>();
        this.size = 0;
    }

    public E pop() {
        E toRemove = stack.remove(stack.size() - 1);
        /**
        int minEl = (int)min.remove(min.size() - 1);
        if (toRemove != minEl) {
            if()
            min.add(minEl);
         }
         */
        size--;
        return toRemove;
    }

    public void push(E in) {
        /**
        int minEl = 0;
        if (size != 0) {
            minEl = (int)min.remove(min.size() - 1);
        }
        if ((int)in < (int)minEl && size > 0) {
            min.add(minEl);
            min.add(in);
        } else if (size == 0) {
            min.add(in);
        } else {
            min.add(minEl);
        }
         */
        stack.add(in);
        size++;
    }
    /**
    public Object min(){
        int minEl = (int)min.remove(min.size()-1);
        min.add(minEl);
        return minEl;
    }
     */
    public static boolean balancingParentheses(char[] arr, Stack<Character> base){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == '['){
                base.push('[');
            }else{
                if(base.size == 0){
                    return false;
                }else{
                    base.pop();
                }
            }
        }
        return base.size == 0;
    }
}
