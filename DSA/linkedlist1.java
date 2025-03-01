public class linkedlist1 {
node head;
node last;

class node{
    int data;
    node next;
    
  node(int data){
        this.data = data ;
        next = null;
    }
}
  
linkedlist1(){
   head = null ;
   last = null ;
   }

linkedlist1(int data){
   head = null ;
   last = null ;
   InsertAtBegining(data);
   }

void InsertAtBegining(int data){
    node newnode = new node(data);
    if(head==null)
        head = last =  newnode;
    else{
        newnode.next = head;
        head = newnode;
    }
}

void InsertAtEnd(int data){
    node newnode = new node(data);
    if(head==null)
        head = last = newnode;
    else{
        last.next = newnode;
        last = newnode;
    }
}

void InsertAtPos(int data, int pos){
    node newnode = new node(data);
    if(pos==0)
       InsertAtBegining(data);
    else{
       node temp = head;
       for(int i=1; i<pos; i++){ 
           temp = temp.next;
           if(temp==null)
               throw new IndexOutOfBoundsException("Invalid Position");
       }
           newnode.next = temp.next;
           temp.next = newnode;
        }
}

void DeletetAtPos(int pos){
    if(head==null)
       throw new IndexOutOfBoundsException("Deletion Attempt on Empty List");
    if(pos==0){
        head=head.next;
        return;
    }
        
    else{
       node temp = head;
       node prev = null;
       for(int i=1; i<=pos; i++){ 
           prev = temp;
           temp = temp.next;
           if(temp==null)
               throw new IndexOutOfBoundsException("Invalid Position");
       }
           prev.next = temp.next;
}
}


void traverse (){
    if(head==null)
        System.out.println("List is Empty");
    else{
        node temp = head ;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}


public void reverse() {
		node prev = null;
		node current = head;
		node next = head.next;
		
		while(current!=null) {
			next=current.next;
			current.next = prev; //reverse link
			prev = current;
			current = next;
		}
		
		head = prev;
	}
    
    public static void main(String args[]) {
        linkedlist1 l1 = new linkedlist1();
        
        l1.InsertAtEnd(15);
        l1.InsertAtEnd(25);
        l1.InsertAtEnd(35);
                l1.InsertAtEnd(55);
        l1.InsertAtPos(45, 3);
        l1.DeletetAtPos(4);
        l1.traverse();
        l1.reverse();
        System.out.println("");
         l1.traverse();

    }
}