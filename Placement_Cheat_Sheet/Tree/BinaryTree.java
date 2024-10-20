package Tree;

public class BinaryTree {
    Node root;
     class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
     }

     public BinaryTree(int data){
        root = new Node(data);
     }

     public  void insertLeft(Node r,int data){
        Node newNode = new Node(data);
        r.left=newNode;
     }

     public  void insertRight(Node r,int data){
        Node newNode = new Node(data);
        r.right=newNode;
     }

     public static void PreOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
     }

     public static void PostOrder(Node root){
        if(root!=null){
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data+" ");
        }
     }

     public static void InOrder(Node root){
        if(root!=null){
            InOrder(root.left);
            System.out.print(root.data+" ");
            InOrder(root.right);
            
        }
    }


     
}
