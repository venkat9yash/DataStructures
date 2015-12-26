/**
 * Created by vrgunapa on 12/25/2015.
 */
import java.io.*;
import java.util.*;
public class DBLLStacks {
    private Stack<Integer> current;
    private Stack<Integer> after;
    private Stack<Integer> buffer;
    public DBLLStacks(){
        current = new Stack<Integer>();
        after = new Stack<Integer>();
        buffer = new Stack<Integer>();
    }
    public void addElement(int element){
        if(current.isEmpty()){
            current.push(element);
        }
        else{
            if(after.isEmpty()){
                after.push(element);
            }
            else{
                while(!after.isEmpty()){
                    buffer.push(after.pop());
                }
                while(!buffer.isEmpty()){
                    after.push(buffer.pop());
                }
            }
        }

    }
    public void moveNext(){
        if(!after.isEmpty()){
            current.push(after.pop());
        }
    }
    public void moveBack(){
        if(!current.isEmpty()){
            after.push(current.pop());
        }
    }
    public int currentElement(){
        if(current.isEmpty()){
            return -1;
        }
        else{
            return current.peek();
        }
    }

}