/**
 * Created by YashGunapati1 on 7/25/15.
 */
public class CustomStack<Type> {
    int top = -1;
    int minTop = -1;
    Type stack[] = (Type[])new Object[10];
    Type minStack[] = (Type[])new Object[10];
    public void push(Type item){
        top = top + 1;
        stack[top] = item;
        if(minTop == -1){
            minTop = minTop + 1;
            minStack[minTop] = item;
        }
        else{
            if((Integer)minStack[minTop] > (Integer)item){
                minTop = minTop + 1;
                minStack[minTop] = item;
            }
        }

    }
    public Type pop(){
        if(top == -1) return null;
        else{
            if(minStack[minTop].equals(stack[top])){
                minStack[minTop] = null;
                minTop = minTop -1;
            }
            stack[top] = null;
            top = top - 1;
            return stack[top + 1];
        }
    }
    public Type getMin(){
        if(minTop != -1){
            return minStack[minTop];
        }
        else{
            return null;
        }
    }
    public void printStack(){
        int traceTop = top;
        while(traceTop != -1){
            System.out.println(stack[traceTop]);
            traceTop = traceTop - 1;

        }

    }

}
