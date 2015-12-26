
import  java.util.Stack;
public class StackClient {

     private static void sortHannoiTowers(Integer top,Stack From, Stack To, Stack Using){
         if(top == 1){
             To.push(From.pop());
         }
         else{
             sortHannoiTowers(top - 1, From, Using, To);
             To.push(From.pop());
             sortHannoiTowers(top - 1, Using, To, From);
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
       /* Stack forSort = new Stack();
        forSort.push(8);
        forSort.push(29);
        forSort.push(2);
        forSort.push(7);

        Stack result = sortAscending(forSort);
        for (int i = 0; i < 4; i++){
            System.out.println("Element" + result.peek());
            System.out.println(result.pop());
        }*/

      /*  DBLLStacks dblist = new DBLLStacks();
        dblist.addElement(5);
        dblist.addElement(7);
        dblist.addElement(2);
        dblist.addElement(9);
        dblist.addElement(0);
        System.out.println(dblist.currentElement());
        dblist.moveNext();
        System.out.println(dblist.currentElement());
        dblist.moveBack();
        System.out.println(dblist.currentElement()); */
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        stack1.add(5);
        stack1.add(4);
        stack1.add(3);
        stack1.add(2);
        stack1.add(1);
        sortHannoiTowers(stack1.size(),stack1,stack3,stack2);
        while(!stack3.isEmpty()){
            System.out.println(stack3.pop());
        }


    }
}

