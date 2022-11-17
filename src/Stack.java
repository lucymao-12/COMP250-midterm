import java.util.ArrayList;

public class Stack {
    ArrayList<Object> stack;
    ArrayList<Object> min = new ArrayList<>();
    int size;

    public Stack() {
        stack = new ArrayList<Object>();
        this.size = 0;
    }

    public int pop() {
        int toRemove = (int)stack.remove(stack.size() - 1);
        int minEl = (int)min.remove(min.size() - 1);
        if (toRemove != minEl) {
            min.add(minEl);
        }
        size--;
        return toRemove;
    }

    public void push(Object in) {
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
        stack.add(in);
        size++;
    }
    public Object min(){
        int minEl = (int)min.remove(min.size()-1);
        min.add(minEl);
        return minEl;
    }
    public boolean balancingParentheses(char[] arr){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == '['){
                this.push('[');
            }else{
                if(this.size == 0){
                    return false;
                }else{
                    this.pop();
                }
            }
        }
        return this.size == 0;
    }
}
