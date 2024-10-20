package Tree;

public class Main {
    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree(10);
        // tree.insertLeft(tree.root,5);
        // tree.insertRight(tree.root,15);
        // tree.insertLeft(tree.root.left, 3);
        // tree.insertRight(tree.root.left, 8);
        // tree.insertLeft(tree.root.right, 12);
        // BinaryTree.PreOrder(tree.root);
        // System.out.println();
        // BinaryTree.InOrder(tree.root);
        // System.out.println();
        // BinaryTree.PostOrder(tree.root);
        // bst b = new bst(1);
        // b.insert(2);
        // b.insert(3);
        // b.insert(4);
        // b.insert(5);
        // b.insert(6);
        // b.insert(7);
        //b.insert(26);
        //ab.inorder(b.root);
        //b.delete(40);
        // b.inorder(b.root);
        // System.out.println();
        
       

        // if(b.search(b.root, 20)==null){
        //     System.out.println("Not found");
        // }else{
        //     System.out.println("Found");
        // }

        // BinarySearchTree bst = new BinarySearchTree(50);
        // bst.insert(60);
        // bst.insert(70);
        // bst.insert(15);
        // bst.insert(65);
        
        // BinarySearchTree.InOrder(bst.root);

        // if(bst.search(bst.root,70)==null) System.out.println("Not found");
        // else System.out.println("Found");

        // bst.delete(65);
        // BinarySearchTree.InOrder(bst.root);

        BT bt = new BT(10);
        bt.insertL(bt.root, 5);
        bt.insertR(bt.root, 15);
        bt.insertL(bt.root.left, 3);
        bt.insertR(bt.root.left, 8);
        bt.insertL(bt.root.right, 12);

        //Recursive Method
        BT.inorder(bt.root);
        System.out.println();
        BT.preorder(bt.root);
        System.out.println();
        BT.postorder(bt.root);
        System.out.println();

        //Iterative Method
        System.out.println();
        bt.inorderI(bt.root);
        System.out.println();
        bt.preorderI(bt.root);
        System.out.println();
        bt.postorderI(bt.root);



    }
}
