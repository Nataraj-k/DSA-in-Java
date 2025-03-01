
public  class BinarySearchTree {
      node root;
      
      class node{
          int data;
          node left, right;
          
          node(int val){
              data = val;
              left = right = null;
          }
      }
      
      BinarySearchTree(int data){
          root = new node(data);
      }
      
      public void Insert (int data){  
          InsertIn(root,data);
      }
      
      node InsertIn(node root, int data){
          
          if(root==null)
              return new node(data);
          
          if(data<root.data)
              root.left = InsertIn(root.left, data);
          
          if(data>root.data)
              root.right = InsertIn(root.right, data);
          
          return root;
      }
      
      void Inorder(){
          InorderIn(root);
      }
      
      void InorderIn(node root){
          if(root!=null){
          InorderIn(root.left);
          System.out.print(root.data+" ");
          InorderIn(root.right);
          }
      }
      
      node Search(int data){
          if(SearchIn(root,data)==null)
              System.out.println("Element Not Found");
          else
              System.out.println("Element Found");
          
          return root;
      }
      
       node SearchIn(node root,int data){
          if(root == null || root.data==data)
              return root;
  
             if(data<root.data)
                 return SearchIn(root.left, data);

                 return SearchIn(root.right, data);
       }
       
       void Delete(int key){
           DeleteNode(root, key);
       }
       
       node DeleteNode(node root, int key){
          if(root==null)
              return root;
           if(key<root.data)
               root.left = DeleteNode(root.left, key);
           else if(key>root.data)
               root.right = DeleteNode(root.right, key);
           else{
               if(root.left==null)
                   return root.right;
               else if(root.right==null)
                   return root.left; 
               
               root.data = min(root.right);
               root.right = DeleteNode(root.right, root.data);
           }
          return root;
       }
       
       int min(node root){
           int min = root.data;
           while(root.left!=null){
             root = root.left;
             min = root.data;
           }
           return min;
       }
       
       
    public static void main(String args[]) {
        BinarySearchTree b1 = new BinarySearchTree(50);
        b1.Insert(60);
        b1.Insert(55);
        b1.Insert(25);
        b1.Insert(20);
        b1.Insert(37);
        b1.Insert(79);
        b1.Insert(89);
        b1.Inorder();
        //b1.Search(37);
         b1.Delete(50);
        System.out.println("");
        b1.Inorder();
    }
}
