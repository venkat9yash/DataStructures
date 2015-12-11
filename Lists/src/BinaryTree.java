import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * Created by YashGunapati1 on 8/4/15.
 */
public class BinaryTree {
    public BinaryTreeNode root;

    BinaryTree() {
        root = null;
    }

    public boolean Insert(int key) {
        BinaryTreeNode new_node = new BinaryTreeNode();
        new_node.value = key;
        //System.out.println("Inserting into ");
        if (root == null) {
            root = new_node;
        } else {
            BinaryTreeNode current = root;
            BinaryTreeNode parent;
            while (true) {
                parent = current;
                if (current.value > key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = new_node;
                        return true;
                    }
                } else if (current.value <= key) {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = new_node;
                        return true;
                    }
                }

            }
        }
        return true;
    }

    public boolean isSymentric(BinaryTreeNode root_node) {
        if (root_node == null) {
            return true;
        } else {
            return checkSymentry(root_node.leftChild, root_node.rightChild);
        }

    }

    public boolean checkSymentry(BinaryTreeNode subTree1, BinaryTreeNode subTree2) {
        if (subTree1 == null && subTree2 == null) {
            return true;
        } else if (subTree1 != null && subTree2 != null) {
            if (subTree1.value == subTree2.value) {
                return checkSymentry(subTree1.leftChild, subTree2.rightChild) && checkSymentry(subTree2.rightChild, subTree2.leftChild);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean isBalanced() {
        if (checkBalanced(root) > 0) return true;
        else return false;
    }

    public int checkBalanced(BinaryTreeNode root_node) {
        if (root_node != null) {
            int leftHeight = checkBalanced(root_node.leftChild);
            if (leftHeight == -1) {
                return -1;
            }
            int rightHeight = checkBalanced(root_node.rightChild);
            if (rightHeight == -1) {
                return -1;
            }
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        } else {
            return -1;
        }

    }

    public boolean isBST(BinaryTreeNode local_root, int min, int max) {
        if (local_root == null) {
            return true;
        } else if (local_root.value < min || local_root.value > max) {
            return false;
        } else {
            return isBST(local_root.leftChild, min, local_root.value) && isBST(local_root.rightChild, local_root.value, max);
        }

    }

    public boolean Delete(int key) {
        BinaryTreeNode current = root;
        BinaryTreeNode parent = root;
        boolean isLeftChild = true;
        while (current.value != key) {
            parent = current;
            if (current.value > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.rightChild == null && current.leftChild == null) {
            if (root == current) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;

            } else {
                parent.rightChild = current.leftChild;
            }

        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.rightChild = current.rightChild;

            } else {
                parent.leftChild = current.rightChild;
            }

        } else {

        }
        return true;

    }
    void exchangeLevelWise(BinaryTreeNode root, int rotate_order){

        printLevelWise(root,1,rotate_order);
    }
    void printLevelWise(BinaryTreeNode root, int order, int rotate){
        if(root != null){
            System.out.println(root.value + " is in the order " + order);
            if(order == rotate){
                BinaryTreeNode temp = root.leftChild;
                root.leftChild = root.rightChild;
                root.rightChild = temp;
            }
            else {
                if (root.leftChild != null) {
                    printLevelWise(root.leftChild, order + 1, rotate);
                }
                if (root.rightChild != null) {
                    printLevelWise(root.rightChild, order + 1, rotate);
                }
            }
        }

    }
    void printTree(BinaryTreeNode node) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        LinkedList<BinaryTreeNode> child_list = new LinkedList<BinaryTreeNode>();
        LinkedList<Integer> value_list = new LinkedList<Integer>();
        HashMap<Integer, LinkedList<Integer>> storage = new HashMap<Integer, LinkedList<Integer>>();

        child_list.add(node);
        int level = 1;
        while (!child_list.isEmpty()){
            System.out.println("Current Level:" + level );
            value_list = new LinkedList<Integer>();
            for(BinaryTreeNode child_node : child_list){
                queue.add(child_node);
                value_list.add(child_node.value);
            }
            storage.put(level, value_list);
            child_list.clear();
            while (!queue.isEmpty()) {
                BinaryTreeNode current = queue.remove();
                System.out.print(current.value + " ");
                if (current.leftChild != null) {
                    child_list.add(current.leftChild);
                }
                if (current.rightChild != null) {
                    child_list.add(current.rightChild);
                }
            }
            System.out.println("");
            level ++;
        }
    }
    void printOrderWise(BinaryTreeNode rnode){
        HashMap<String,ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        LinkedList<BinaryTreeNode> child_list = new LinkedList<BinaryTreeNode>();
        child_list.add(rnode);
        int level = 0;
        while(child_list != null) {
            System.out.println(level);
            for (BinaryTreeNode child_element : child_list) {
                System.out.println("Inputing Child Element" + child_element.value);
                queue.add(child_element);
            }
            child_list.clear();
           while (queue != null) {
                BinaryTreeNode node = queue.getFirst();
                queue.clear();
                System.out.println("Element" + node.value);
                /*if (node.rightChild != null) {
                    child_list.add(node.rightChild);
                }
                if (node.leftChild != null) {
                    child_list.add(node.leftChild);
                }*/
            }
            level++;
        }
    }

    void preOrder(BinaryTreeNode local_root) {
        if (local_root != null) {
            System.out.println(local_root.value);
            preOrder(local_root.leftChild);
            preOrder(local_root.rightChild);
        }

    }

    boolean dfsearch(BinaryTreeNode root, int key) {
        if (root == null) {
            return false;
        } else if (root.value == key) {
            System.out.println("key found");
            return true;
        } else {
            return dfsearch(root.leftChild, key) || dfsearch(root.rightChild, key);
        }
    }

    int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + max(height(node.leftChild), height(node.rightChild));
        }

    }


    int lca(BinaryTreeNode btnode, int a, int b){
        if(btnode == null){
            return 0;
        }
        if(btnode.value <= a && btnode.value <= b ){
            return lca(btnode.rightChild, a, b);
        }
        else if(btnode.value > a && btnode.value > b){
            return lca(btnode.leftChild, a, b);
        }
        else{
            return btnode.value;
        }

    }
    boolean bfsearch(BinaryTreeNode root, int key){
        if(root == null){
            return false;
        }
        Queue<BinaryTreeNode> childrenList = new Queue<BinaryTreeNode>();
        childrenList.add(root);
        while(childrenList != null){
            BinaryTreeNode current = childrenList.remove();
            if(current.value == key){
                return true;
            }
            if(current.leftChild != null){
              childrenList.add(current.leftChild);
            }
            if(current.rightChild != null){
                childrenList.add(current.rightChild);
            }

        }
        return false;
    }

    class BinaryTreeNode{
        public BinaryTreeNode leftChild;
        public BinaryTreeNode rightChild;
        public int value;

    }
}
