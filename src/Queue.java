import java.util.ArrayList;

public class Queue<E> {
    Stack main = new Stack();
    Stack temp = new Stack();

    ArrayList<E> array = new ArrayList<E>();
    int size = 0;
    int head = 0;

    public E dequeue(){
        if(this.size == 0){
            throw new RuntimeException("Cannot dequeue from empty queue");
        }
        E elem = null;
        E returnValue;
        for(int i = 0; i < this.size; i++){
            elem = (E) main.pop();
            temp.push(elem);
        }
        returnValue = (E) temp.pop();
        for(int i = 0; i < this.size-1; i++){
            elem = (E) temp.pop();
            main.push(elem);
        }
        this.size--;
        return returnValue;
    }
    public void enqueue(E in){
        main.push(in);
        this.size++;
    }
    public void circleEnqueue(E in){
        if(this.size == array.size()){
            System.out.println("test");
            ArrayList<E> temp = new ArrayList<E>();
            for(int i = 0; i < this.size*2; i++){
                temp.add(null);
            }
            for(int i = 0; i < this.size; i++){
                temp.set(i, array.get((head + i)%this.size));
            }
            head = 0;
            array = temp;
        }
        array.set((head + this.size)%this.array.size(), in);
        this.size++;
    }
    public E circleDequeue(){
        E element;
        if(this.size <= 0){
            throw new IllegalArgumentException();
        }
        //element = array.remove(head);
        element = array.get(head);
        array.set(head, null);
        this.size--;
        head = (head+1)%this.array.size();
        return element;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Character> queue = new Queue<Character>();
        queue.array.add('-');
        queue.array.add('-');
        queue.array.add('-');
        queue.array.add('-');
        queue.size = 2;
        queue.array.set(2, 'F');
        queue.array.set(3, 'C');
        queue.head = 2;
        queue.circleEnqueue('P');
        queue.circleDequeue();
        queue.circleEnqueue('E');
        for(Character character : queue.array){
            System.out.println(character);
        }
    }
}
