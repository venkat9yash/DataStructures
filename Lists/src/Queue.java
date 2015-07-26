/**
 * Created by YashGunapati1 on 7/25/15.
 */
public class Queue<Type> {
    int front= -1;
    int last = 0;
    Type queue[] = (Type[])new Object[10];

    public Type remove(){
        if(last <= front ){
            last = last + 1;
            return queue[last - 1];
        }
        else return null;

    }
    public void add(Type item){
        front = front + 1;
        queue[front] = item;
    }
}
