public class CircularLinkedList {
     node last;
     
     CircularLinkedList(){
         last = null;
     }
     
     class node{
         int data;
         node next;
         
         node(int data){
             this.data = data;
             next = null;
         }
     }
     
     void Insert(int data){
         node newnode = new node(data);
         if(last==null){
             newnode.next = newnode;
             last = newnode;
         }else{
             newnode.next = last.next;
             last.next = newnode;
             last = newnode;
         }
     }
     
     void Display(){
         if(last==null)
             throw new IndexOutOfBoundsException("List is Empty !");
         else{
             node temp = last.next;
             do{
                 System.out.print(temp.data+" ");
                 temp = temp.next;
             }while(temp!=last.next);
         }
     }
     
     void InsertAtPos(int pos, int data){
         node newnode = new node(data);
         if(pos==0){
             newnode.next = last.next;
             last.next = newnode;
         }else{
             node temp = last.next;
             for(int i=1; i<pos; i++){
                 temp = temp.next;
             }
             if(temp==last.next)
                     throw new IndexOutOfBoundsException("Insertion At Wrong Place");
             
               if(temp==last){
                   newnode.next = last.next;
                   last.next = newnode;
                   last = newnode;
               }else{
                   newnode.next = temp.next;
                   temp.next = newnode;
               }
         }
     }
     
     void DeleteAtPos(int pos){
         if(pos==0){
             node temp = last.next;
             last.next = temp.next;
         }else{
             node temp = last.next ; 
             node prev = null;
             for(int i=1; i<=pos; i++){
                 prev = temp;
                 temp = temp.next;
             }
             if(temp==last.next){
                throw new IndexOutOfBoundsException("Insertion At Wrong Place");
             }
             if(temp==last){
                 prev.next = temp.next;
                 last = prev;
                 return;
             }
             prev.next = temp.next;
         }
             
     }
    
    public static void main(String args[]) {
       CircularLinkedList c1 = new CircularLinkedList();
       c1.Insert(10);
       c1.Insert(20);
       c1.Insert(30);
       c1.Insert(40);
       c1.Insert(50);
       c1.Display();
       //c1.InsertAtPos(5, 0);
        System.out.println("");
        c1.DeleteAtPos(3);
              c1.Display();


    }
}
