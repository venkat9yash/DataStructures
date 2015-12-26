import sun.awt.image.ImageWatched;

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
    public static void findKBefore(LinkedList<Integer> list, int k){
        if(list.head == null){
            System.out.println("Not Valid");
        }
        LinkedList.Node<Integer> runner = list.head;
        int count = 0;
        while(count < k){
            runner = runner.next;
            count++;
        }
        LinkedList.Node<Integer> current = list.head;
        while(runner.next != null){
            runner = runner.next;
            current = current.next;
        }
        System.out.println(current.data );

    }
    public static LinkedList<Integer> seperatebyPivot(LinkedList<Integer> list, int pivot){
        if(list.head == null){
            System.out.println("Not Valid");
        }
        LinkedList.Node<Integer> runner = list.head;
        LinkedList.Node<Integer> builder;
        LinkedList.Node<Integer> alt_head = null;
        if(runner.data > pivot){
            builder = null;
            alt_head = runner;
        }
        else{
            builder = runner;
        }
        while(runner.next.next != null){
            //System.out.println(runner.next.data);
            if(runner.next.data <= pivot){
                LinkedList.Node<Integer> temp;
                temp = runner.next;
                runner.next = runner.next.next;
                temp.next = alt_head;
                if(builder == null){
                    builder = temp;
                    list.head = builder;
                }
                else{
                    builder.next = temp;
                }
            }
            else {
                if(alt_head == null){
                    alt_head = runner.next;
                }

            }
            runner = runner.next;
        }
        return list;
    }
    public static boolean isPalindrom(LinkedList.Node<Integer> node){
        int length =0;
        LinkedList.Node<Integer> first_node = node;
        while(first_node != null){
            length += 1;
            first_node = first_node.next;
        }
        int half_length = length/2;
        int count = 1;
        LinkedList.Node<Integer> second_node = node;
        while(count <= half_length){
            second_node = second_node.next;
            count++;
        }
       // System.out.println(length);
       // System.out.println(second_node.data);
        LinkedList.Node<Integer> reverse = null;
        first_node = node;
        while(first_node != second_node){
           // System.out.println(first_node.data);
            LinkedList.Node<Integer> temp = first_node.next;
            first_node.next = reverse;
            reverse = first_node;
            first_node = temp;
        }
        if(length%2 == 1){
            second_node = second_node.next;
        }
        while(reverse != null && second_node!=null){
            System.out.println(reverse.data);
            System.out.println(second_node.data);
            if(reverse.data != second_node.data){
                return false;
            }
            reverse = reverse.next;
            second_node = second_node.next;
        }
        return true;
    }
    public static void reversefromMN(LinkedList<Integer> list, int m, int n){
        LinkedList.Node<Integer> dummy = list.head;
        LinkedList.Node<Integer> prev_node = dummy;
        for(int i=0; i < m -1; i++){
            //System.out.println(prev_node.data);
            prev_node = prev_node.next;
        }
        LinkedList.Node<Integer> first_node = prev_node.next;
        LinkedList.Node<Integer> reverse = first_node.next;
        for(int i=0; i < n-m; i++){
            //System.out.println(reverse.data);
            first_node.next = reverse.next;
            reverse.next = prev_node.next;
            prev_node.next = reverse;
            reverse = first_node.next;
        }
        while(dummy !=null){
            System.out.println(dummy.data);
            dummy = dummy.next;
        }
        list.head = dummy;
    }
    public static void makeListCircular(LinkedList<Integer> list, int pos){
        LinkedList.Node<Integer> node = list.head;
        for(int i=0 ; i < pos; i++){
            node = node.next;
        }
        LinkedList.Node<Integer> pos_node = node;
        while(node.next != null){
            node = node.next;
        }
        node.next = pos_node;

    }
    public static int findCircularNodePos(LinkedList<Integer> list){
        LinkedList.Node<Integer> slow_node = list.head;
        LinkedList.Node<Integer> fast_node = slow_node.next;
        while(slow_node != fast_node){
            slow_node = slow_node.next;
            fast_node = fast_node.next.next;
        }
        int pos =0;
        System.out.println(fast_node.data);
        slow_node = list.head;
        fast_node = fast_node.next;
        while(slow_node != fast_node){
            slow_node = slow_node.next;
            fast_node = fast_node.next;
            pos += 1;
        }

        return pos;
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
        number1.addLast(12);
        number1.addLast(9);
        number1.addLast(5);
        number1.addLast(9);
        number1.addLast(12);
        number1.addLast(7);

        //findKBefore(number1,2);
        //seperatebyPivot(number1,12);

        //System.out.println(isPalindrom(number1.head));
        //reversefromMN(number1,3,5);
        makeListCircular(number1,2);
        System.out.println(findCircularNodePos(number1));

        //result.addLists(number1.head, number2.head, 0);
        //number1.printList();
        //result.head = reverseList(number1.head);
        //result.printList();
        //result = mergeLists(number1,number2);
        //result.printList();
        //number1.findMiddle();



    }
}
