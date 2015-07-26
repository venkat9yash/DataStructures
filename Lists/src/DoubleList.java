/**
 * Created by YashGunapati1 on 7/26/15.
 */
public class DoubleList<Type> {
    Node<Type> head = null;
    public void addFirst(Type data){
        if(head == null){
            head = new Node<Type>(data, null,null);
            head.rlink = head;
            head.llink = head;
        }
        else{
            Node<Type> new_node = new Node<Type>(data,head,head.rlink);
            head.rlink.llink = new_node;
            head.rlink = new_node;
        }
    }
    public void addLast(Type data){
        if(head == null){
            addFirst(data);
        }
        else{
            Node<Type> runner = head;
            while(runner.rlink != head){
                runner = runner.rlink;
            }
            Node<Type> new_node = new Node<Type>(data, runner, runner.rlink);
            runner.rlink.llink = new_node;
            runner.rlink = new_node;
        }

    }
    public void traverseBack(){
        if(head != null){
            Node<Type> runner = head;
            do {
                System.out.println(runner.data);
                runner = runner.llink;
            }
            while(runner != head);
        }
    }
    public void traverseFront(){
        if(head != null){
            Node<Type> runner = head;
            do {
                System.out.println(runner.data);
                runner = runner.rlink;
            }
            while(runner != head);
        }

    }
    public void delete(Type key){
        if(head != null) {
            Node<Type> runner = head;
            do {
                if (runner.data.equals(key)) {
                    if(runner == head){
                        head = head.rlink;
                    }
                    runner.llink.rlink = runner.rlink;
                    runner.rlink.llink = runner.llink;
                    runner = null;
                    break;
                }
                runner = runner.rlink;
            }while(runner != head);

        }
    }
    private static class Node<Type>{
        Type data;
        Node<Type> llink;
        Node<Type> rlink;
        public Node(Type data, Node<Type> llink ,Node<Type> rlink){
            this.data = data;
            this.llink = llink;
            this.rlink = rlink;
        }
    }
}
