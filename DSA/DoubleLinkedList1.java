
public class DoubleLinkedList1 {
    node head;
    node tail;
    
    DoubleLinkedList1(){
        head = null;
        tail = null;
    }
    
    class node{
        int data;
        node next;
        node prev;
        
        node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    
    void Insert(int data){
        node newnode = new node(data);
        if(head==null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    
    void traverse(){
        if(head==null)
            throw new IndexOutOfBoundsException("List is empty");
         node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    
    
     void reverse(){
        if(head==null)
            throw new IndexOutOfBoundsException("List is empty");
         node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
    }
     
     void InsertAtPosition(int pos, int data){
         node newnode = new node(data);
         if(pos==0){
             newnode.next = head;
             head.prev = newnode;
             head = newnode;
         }
         else{
             node temp = head;
             for(int i=1; i<pos; i++){
                 temp=temp.next;
                 if(temp==null) 
				throw new IndexOutOfBoundsException("Invalid Pos " + pos);
             }
             newnode.next = temp.next;
             newnode.prev = temp;
             
             if(temp==tail)
			tail=newnode;
		else
			temp.next.prev = newnode;
		temp.next = newnode;
         }
     }
     
     
     void DeleteAtPosition(int pos){
         if(pos==0){
             head = head.next;
         }
         else{
             node temp = head;
             node prev = null;
             for(int i=1; i<=pos; i++){
                 prev = temp;
                 temp = temp.next;
                 if(temp==null) 
		   throw new IndexOutOfBoundsException("Invalid Pos " + pos);
             }
             prev.next = temp.next;
                 if(temp.next==null)
                     tail = prev;
                 else{
                 temp.next.prev = prev;
                 }             
         }
     }
     
     
     void Search(int key){
         node temp = head;
         int pos=0;
         while(temp!=null){
         if(temp.data==key){
             System.out.println("Element Found AT "+pos+" position");
             return;
         }else{
             temp = temp.next;
             pos++;
         }
     }
         System.out.println("Element Not Found");
     }

    public static void main(String args[]) {
        DoubleLinkedList1 d1 = new DoubleLinkedList1();
        d1.Insert(6);
        d1.Insert(10);
        d1.Insert(20);
        d1.Insert(30);
        d1.InsertAtPosition(0, 15);
        d1.traverse();
        System.out.println("");
        //d1.reverse();
        //d1.InsertAtPosition(5, 25);
        //d1.DeleteAtPosition(4);
        //d1.traverse();
       d1.Search(30);
    }
}
