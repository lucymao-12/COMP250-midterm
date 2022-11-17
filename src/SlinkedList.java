import java.util.Iterator;

public class SlinkedList<E> implements Iterable<E>{
    SNode<E> head;
    public Iterator<E> iterator(){
        return new SLLIterator<E>(this);
    }
}

class SLLIterator<E> implements Iterator<E>{
    SNode<E> curr;
    SLLIterator(SlinkedList<E> list){
        curr = list.head;
    }
    public boolean hasNext(){
        return(curr != null);
    }
    public E next(){
        SNode tmp = curr;
        curr = curr.next;
        return (E) tmp.element;
    }
}
class SNode<E>{
    SNode<E> next;
    //SNode<E> head;
    E element;

}
