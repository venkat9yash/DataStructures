/**
 * Created by YashGunapati1 on 7/25/15.
 */
public class LinkedList<Type> {

    Node<Type> head = null;
    public void addFirst(Type data){
        if(head == null){
            head = new Node<Type>(data,null);
        }
        else{
            Node<Type> new_item = new Node<Type>(data, head.next);
            head.next = new_item;
        }

    }
    public void addLast(Type data){
        if(head == null){
         addFirst(data);
        }
        else {
            Node<Type> next_node = head;
            while(next_node.next != null){
                next_node = next_node.next;

            }
            next_node.next = new Node<Type>(data,null);
        }

    }

    public void addAfter(Type key, Type data){
        Node<Type> search_key = head;
        while(search_key != null){
            if(search_key.data == key){
                Node<Type> new_node = new Node<Type>(data, search_key.next);
                search_key.next = new_node;
                return;
            }
            search_key = search_key.next;

        }

    }
    public void delete(Type data){
        if(head != null){
            Node<Type> finder = head;
            Node<Type> runner = null;
            if(head.data == data){
                head = head.next;
                return;
            }
            while(finder != null && finder.data != data){
                runner = finder;
                finder = finder.next;
            }
            if(finder.data == data && finder != null){
                runner.next = finder.next;
                finder = null;
            }
        }
    }
    public void printList(){
        Node<Type> iterator = head;
        while(iterator.next != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
        System.out.println(iterator.data);
    }
    public void removeDuplicates(){
        if(head!= null){
            Node<Type> current = head;
            while(current != null){
                Node<Type> runner = current;
                while(runner.next != null){
                    if(runner.next.data.equals(current.data)){
                        runner.next = runner.next.next;
                    }
                    else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
            printList();
        }

    }
    public Node<Integer> addLists(Node<Integer> number1, Node<Integer> number2, Integer carry){
        Integer sum = (number1 != null ? number1.data : 0) + (number2 != null ? number2.data : 0) + carry;
        Node<Integer> result = new Node<Integer>(sum % 10, null);

        if(number1 != null || number2 != null){
            Node<Integer> result_node = addLists(number1.next == null ? null : number1.next, number2.next == null ? null : number2.next, sum >= 10 ? 1 : 0 );
            result.next = result_node;
        }
        System.out.println(result.data);
        return  result;
    }

    public void findMiddle(){
        Node<Type> current = this.head, runner = this.head;
        while(runner !=null && runner.next != null){
            current = current.next;
            runner = runner.next.next;
        }

         System.out.println("Middle Element is:" + current.data);

    }

    public void pivotAround(Integer key){
        if(head!= null){
            Node<Type> runner = head;
            while(runner.next != null){
                if(runner.next.data.equals(key)){
                    Node<Type> pivot = runner.next;
                    Node<Type> organizer = head;
                    boolean passPivot = false;
                    while(organizer != null){
                        if(((Integer)organizer.data > (Integer)pivot.data) & !passPivot){
                            if(organizer == head){
                                head = organizer.next;
                            }
                            organizer.next = pivot.next;
                            pivot.next = organizer;
                        }
                        else if(((Integer)organizer.data <= (Integer)pivot.data) & passPivot){
                            organizer.next = pivot;
                            runner.next = organizer;

                        }
                        if(organizer == pivot) passPivot = true;
                        organizer = organizer.next;
                    }

                    break;
                }
                runner = runner.next;
            }

        }

    }

    public static class Node<Type> {
        Node<Type> next;
        Type data;
        public Node(Type data, Node<Type> next){
            this.next = next;
            this.data = data;

        }

    }
}

