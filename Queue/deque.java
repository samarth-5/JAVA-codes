import java.util.*;
class deque
{
    public static void main(String[] args) 
    {
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        System.out.println(deque.getLast());
    }
}