

class Queue1{
    int front,rear,x=5;
    int data[] = new int[x];
    
    Queue1(){
        front=-1;
        rear=-1;
    }
    
    void enqueue(int x){
        if(rear==x-1)
          System.out.println("overflow");
          else{
            if(front==-1){
                front++;
            }
         data[++rear]=x;
         System.out.println("enqueue successfully");
    }
}


void dequeue(){
    if(front==-1 || front>rear){
        System.out.println("underflow");
    }else{
    front++;
    System.out.println("Dequeue successfully");
    }
}

void peek(){
    System.out.println(data[front]);
}
}

public class queue {
    public static void main(String args[]) {
    Queue1 q1 = new Queue1();
    q1.enqueue(5);
    q1.enqueue(15);
    q1.enqueue(25);

    q1.dequeue();
    q1.dequeue();
    q1.peek();
    }
}

