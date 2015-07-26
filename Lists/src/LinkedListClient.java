/**
 * Created by YashGunapati1 on 7/26/15.
 */
public class LinkedListClient {
    public static void main(String args[]) {
        //Stack
        //Stack stackList= new Stack<Float>();
        //stackList.push(5.5);
        //stackList.push(10.2);
        //stackList.push(5.0);
        //System.out.println(stackList.pop());

        //Queue
        //Queue queueList = new Queue<Integer>();
        //queueList.add(5);
        //queueList.add(10);
        //System.out.println(queueList.remove());
        //System.out.println(queueList.remove());

        //Linked List
/*       LinkedList linkedList = new LinkedList<Integer>();
        linkedList.addLast(4);
        linkedList.addLast(3);
        linkedList.addLast(15);
        linkedList.addFirst(3);
        linkedList.addFirst(6);
        linkedList.addFirst(12);
        linkedList.addAfter(3, 15);
        linkedList.addAfter(6, 9);
        linkedList.delete(9);
        linkedList.delete(4);
        linkedList.removeDuplicates();*/

        LinkedList number1 = new LinkedList<Integer>();
        LinkedList number2 = new LinkedList<Integer>();
        LinkedList result = new LinkedList<Integer>();
        number1.addLast(7);
        number1.addLast(3);
        number1.addLast(6);

        number2.addLast(2);
        number2.addLast(1);
        number2.addLast(8);

        result.addLists(number1.head, number2.head, 0);


    }
}
