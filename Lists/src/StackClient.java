/**
 * Created by YashGunapati1 on 7/28/15.
 */
import java.util.IntSummaryStatistics;
import  java.util.Stack;
public class StackClient {

     private static void sortHannoiTowers(Integer top,Stack From, Stack To, Stack Using){
         System.out.println(top);
         if(top <= 0)return;
         else{
             sortHannoiTowers(top - 1, From, To, Using);
             int disk = (Integer) From.pop();
             if(!(!To.isEmpty())){
                 To.push(disk);
             }

             System.out.println("Moving Disk " + disk );
             if(top - 1 !=0) {
                 sortHannoiTowers(top - 1, Using, To, From);
             }

         }

    }
    private static Stack sortAscending(Stack mainStack){
        Stack bufferStack = new Stack();
        while(!mainStack.isEmpty()){
            Integer temp = (Integer) mainStack.pop();
            while(!bufferStack.isEmpty() && temp > (Integer)bufferStack.peek()){
                System.out.println("Removing " + (Integer)bufferStack.peek());
                mainStack.push(bufferStack.pop());
            }
            System.out.println("Adding " + temp);
            bufferStack.push(temp);
        }
        return bufferStack;
    }

    public static void main(String args[]){
        CustomStack stackList= new CustomStack<Integer>();
        //stackList.push(5);
        stackList.push(10);
        stackList.push(6);
      //  stackList.printStack();
       // System.out.println(stackList.getMin());

  /*      Stack A = new Stack();
        Stack B = new Stack();
        Stack C = new Stack();
        for (int i = 0; i < 3; i++)
        {
            A.push ( new Integer(i) );
        }
        sortHannoiTowers(3,A,B,C);*/

        //Queue
        //Queue queueList = new Queue<Integer>();
        //queueList.add(5);
        //queueList.add(10);
        //System.out.println(queueList.remove());
        //System.out.println(queueList.remove());


        //Sorting
        Stack forSort = new Stack();
        forSort.push(8);
        forSort.push(29);
        forSort.push(2);
        forSort.push(7);

        Stack result = sortAscending(forSort);
        for (int i = 0; i < 4; i++){
            System.out.println("Element" + result.peek());
            System.out.println(result.pop());
        }



    }
}

