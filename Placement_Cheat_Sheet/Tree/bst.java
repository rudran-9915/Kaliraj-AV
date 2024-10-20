package Tree;

public class bst {
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

    public bst(int val){
        root = new Node(val);
    }

    public void insert(int data){
        insert(root,data);
    }
    
    public Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }

        if(key<root.data){
            root.left = insert(root.left,key);
        }
        else if(key>root.data){
            root.right=insert(root.right,key);
        }
        return root;
    }


    public void inorder(Node root){
        if(root!=null){
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        }
    }



    

    public Node search(Node root,int searKey){
        if(root==null || root.data==searKey){
            return root;
        }
        if(searKey<root.data){
            return search(root.left, searKey);
        }
        return search(root.right,searKey);
    }

    public void delete(int value){
        delete(root, value);
    }

    public Node delete(Node root,int delData){
        if(root==null){
            return root;
        }
        if(delData<root.data){
            root.left=delete(root.left,delData);
        }
        else if(delData>root.data){
            root.right=delete(root.right,delData);
        }
        else{
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                root.data = getMin(root.right,delData);
                root.right=delete(root.right,root.data);
            }
        }
        return root;
    }

    public int getMin(Node root,int val){
        int minVal = root.data;
        while(root.left!=null){
            minVal = root.left.data;
            root=root.left;
        }
        return minVal;
    }

}
