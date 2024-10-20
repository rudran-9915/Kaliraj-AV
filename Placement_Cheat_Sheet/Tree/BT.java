package Tree;

import java.util.Stack;

public class BT {
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

    public BT(int data){
        root = new Node(data);
    }

    public void insertL(Node n,int val){
        Node newNode = new Node(val);
        n.left=newNode;
    }

    public void insertR(Node n,int val){
        Node newNode = new Node(val);
        n.right=newNode;
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            
            preorder(root.right);
        }
    }

    public static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void preorderI(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
    }

    public  void postorderI(Node root){
        Node current = root;
        Stack<Node> st2 = new Stack<>();
        while(current!=null || !st2.isEmpty()){
            if(current!=null){
            st2.push(current);
            current=current.left;
        }
        else{
            Node temp = st2.peek().right;
            if(temp==null){
                temp = st2.pop();
                System.out.print(temp.data+" ");
                while(!st2.isEmpty() && temp==st2.peek().right){
                    temp=st2.pop();
                    System.out.print(temp.data+" ");
                }
            }
            else{
                current=temp;
            }
        }
    }

    }

    public void inorderI(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st3 = new Stack<>();
        Node temp = root;
        while(!st3.isEmpty() || temp!=null){
            if(temp!=null){
                st3.push(temp);
                temp=temp.left;
            }
            else{
                temp = st3.pop();
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }


}
