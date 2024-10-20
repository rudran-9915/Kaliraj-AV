package Tree;
public class BinarySearchTree{
    Node root;
    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    public BinarySearchTree(int data){
        root = new Node(data);
    }

    public void insert(int key){
        insert(root,key);
    }
   
    public Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.left=insert(root.left,key);
        }
        else{
            root.right=insert(root.right,key);
        }
        return root;

    }

    public static void InOrder(Node root){
        if(root!=null){
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
        }
    }

    public Node search(Node root,int key){
        if(root == null || root.data==key){
            return root;
        }

        if(key<root.data){
            return search(root.left, key);
        }
        return search(root.right,key);
    }

    public void delete(int val){
        delete(root,val);
    }

    public Node delete(Node root,int val){
        if(root==null){
            return root;
        }
        if(val<root.data){
            root.left=delete(root.left,val);
        }
        else if(val>root.data){
            root.right=delete(root.right,val);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            root.data = getMin(root.right);
            root.right= delete(root.right,root.data); 
        }
        return root; 
    }

    public int getMin(Node root){
        int MinValue = root.data;
        while(root.left!=null){
            MinValue = root.left.data;
            root=root.left;
        }
        return MinValue;
    }


}