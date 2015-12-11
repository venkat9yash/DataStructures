/**
 * Created by YashGunapati1 on 8/4/15.
 */
public class BinaryTreeClient {
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.Insert(10);
        tree.Insert(3);
        tree.Insert(14);
        tree.Insert(17);
        tree.Insert(27);
        tree.Insert(37);
        tree.Insert(47);
        tree.Insert(71);
        tree.Insert(14);
        tree.Insert(12);
        tree.Insert(9);
       // tree.preOrder(tree.root);
       // tree.dfsearch(tree.root, 23);
        //System.out.println(tree.lca(tree.root, 27, 47));
        //tree.printLevelWise(tree.root, 1);
        //tree.printOrderWise(tree.root);
        //tree.exchangeLevelWise(tree.root,1);
        tree.printTree(tree.root);
    }
}
