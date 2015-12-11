/**
 * Created by YashGunapati1 on 7/25/15.
 */
public class CircularList<Type> {
    Node<Type> head = null;
    public void addFirst(Type data){
        if(head == null){
            head = new Node<Type>(data, null);
            head.link = head;
        }
        else{
            Node<Type> new_node = new Node<Type>(data, head.link);
            head.link = new_node;
        }
    }
    public void addLast(Type data){
        if(head == null){
            addFirst(data);
        }
        else{
            Node<Type> runner = head;
            while(runner.link != head){
                runner = runner.link;
            }
            Node<Type> new_node = new Node<Type>(data, runner.link);
            runner.link = new_node;
        }

    }
    public void delete(Type key){
        if(head !=null){
            Node<Type> back = head;
            Node<Type> runner = back.link;

            do{
                if(runner.data.equals(key)) {
                    back.link = runner.link;
                    if(runner == head){
                        head = back;
                    }
                    else{
                        runner = null;
                    }
                    break;
                }
                back = runner;
                runner = runner.link;
            }
            while(runner != head.link);

        }

    }

    public void traverse(){
        if(head != null){
            Node<Type> runner = head;
            do {
                System.out.println(runner.data);
                runner = runner.link;
            }
            while(runner != head);
        }
    }
    private static class Node<Type>{
        Type data;
        Node<Type> link;
        public Node(Type data, Node<Type> link){
            this.data = data;
            this.link = link;
        }
    }
}
