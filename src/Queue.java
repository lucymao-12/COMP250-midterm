import java.util.ArrayList;

public class Queue {
    Stack main = new Stack();
    Stack temp = new Stack();

    ArrayList<Integer> array = new ArrayList<Integer>();
    int size = 0;
    int head = 0;

    public int dequeue(){
        if(this.size == 0){
            throw new RuntimeException("Cannot dequeue from empty queue");
        }
        int tInt = 0;
        int returnValue;
        for(int i = 0; i < this.size; i++){
            tInt = main.pop();
            temp.push(tInt);
        }
        returnValue = temp.pop();
        for(int i = 0; i < this.size-1; i++){
            tInt = temp.pop();
            main.push(tInt);
        }
        this.size--;
        return returnValue;
    }
    public void enqueue(int in){
        main.push(in);
        this.size++;
    }
    public void circleEngueue(int in){
        if(this.size == array.size()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < this.size; i++){
                temp.set(i, array.get((head + i)%this.size));
            }
            head = 0;
            array = temp;
        }
        array.set((head + size)%this.size, in);
        this.size++;
    }
    public int circleDequeue(){
        int element;
        if(this.size <= 0){
            throw new IllegalArgumentException();
        }
        element = array.get(head);
        this.size--;
        head = (head+1)%this.size;
        return element;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(20);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(43);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(22);
    }
}
