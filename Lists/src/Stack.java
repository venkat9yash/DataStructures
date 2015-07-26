/**
 * Created by YashGunapati1 on 7/25/15.
 */
public class Stack<Type> {
    int top = -1;
    Type stack[] = (Type[])new Object[10];
    public void push(Type item){
        top = top + 1;
        stack[top] = item;

    }
    public Type pop(){
        if(top == -1) return null;
        else{
            top = top - 1;
            return stack[top + 1];
        }
    }

}
