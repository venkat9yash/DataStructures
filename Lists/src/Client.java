/**
 * Created by YashGunapati1 on 7/25/15.
 */
import java.util.Scanner;

public class Client {
    public static int sortStartingPoint(Queue<Integer> petrol, int size){
        int index = 1;
        int tank = 0;
        int p = 0, m = 0;
        while(index <= size){
            p = petrol.remove();
            if((tank+p)-m >= 0){
                tank = (tank+p) - m;
            }
            else{
                index++;
                tank = 0;
            }
            petrol.add(p);
            petrol.add(m);

        }
        return index;
    }
    public static void main(String args[]){
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
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.addLast(4);
        linkedList.addLast(3);
        linkedList.addLast(15);
        linkedList.addFirst(3);
        linkedList.addFirst(6);
        linkedList.addFirst(12);
        linkedList.addAfter(3,15);
        linkedList.addAfter(6,9);
        linkedList.delete(9);
        linkedList.delete(4);
        linkedList.removeDuplicates();
        //linkedList.printList();

        //Circular List
/*      CircularList circularList = new CircularList<Float>();
        circularList.addLast(8.3);
        circularList.addLast(9.2);
        circularList.addLast(7.2);
        circularList.addFirst(10.0);
        circularList.delete(8.3);
        circularList.addLast(9.0);
        circularList.delete(9.0);
        circularList.traverse();*/

        //Double Linked List

/*        DoubleList doubleList = new DoubleList<Integer>();
        doubleList.delete(5);
        doubleList.addLast(5);
        doubleList.addFirst(4);
        doubleList.addLast(9);

        doubleList.traverseBack();
        doubleList.traverseFront();*/
        Queue<Integer> petrol = new Queue<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Petrol Bunks:");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i< n; i++){
            String [] input = sc.nextLine().split(" ");
            petrol.add(Integer.parseInt(input[0]) - Integer.parseInt(input[1]));
            //System.out.println(sc.nextLine());
        }
        sortStartingPoint(petrol, n);

    }
}
