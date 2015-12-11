import java.lang.reflect.Type;

/**
 * Created by YashGunapati1 on 7/26/15.
 */
public class LinkedListClient {
    public static LinkedList.Node<Integer> reverseList(LinkedList.Node<Integer> node){
        if(node == null || node.next == null){
            return node;
        }

        LinkedList.Node<Integer> new_node = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return new_node;
    }
    public static LinkedList<Integer> mergeLists(LinkedList first, LinkedList second){
        LinkedList<Integer> mergeList = new LinkedList<Integer>();
        LinkedList.Node<Integer> one = first.head;
        LinkedList.Node<Integer> two = second.head;
        while(one!=null && two !=null){
            if(one.data <= two.data){
                mergeList.addLast(one.data);
                one = one.next;
            }
            else{
                mergeList.addLast(two.data);
                two = two.next;
            }

        }
        while(one != null){
            mergeList.addLast(one.data);
            one = one.next;
        }
        while(two != null){
            mergeList.addLast(two.data);
            two = two.next;
        }
        return mergeList;
    }
    public static boolean checkCycle(LinkedList<Integer> list){
        return true;
    }
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
        number1.addLast(10);
        number1.addLast(12);

        number2.addLast(1);
        number2.addLast(9);
        number2.addLast(14);
        number2.addLast(18);

        //result.addLists(number1.head, number2.head, 0);
        //number1.printList();
        //result.head = reverseList(number1.head);
        //result.printList();
        //result = mergeLists(number1,number2);
        //result.printList();
        number1.findMiddle();



    }
}
