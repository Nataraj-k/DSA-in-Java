class stack {
    int top,x=5;
    int value[]  = new int[x];
    
    stack(){
        top=-1;
    }
    
    void push(int data){
        if(top==x-1)
            System.out.println("stack overflow");
        else{
        value[++top]=data;
        System.out.println("data pushed succesfully");
        }
    }
    
    void pop(){
        if(top==-1)
            System.out.println("stack underflow");
        else{
        top--;
        System.out.println("data peaked succesfully");
        }
    }

    void peek(){
         System.out.println(value[top]);
    }

    boolean isEmpty(){
        return top==-1 ;
    }

    boolean isFull(){
        return top==x-1 ;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        stack s1 = new stack();
        s1.push(6);
        s1.push(3);
        s1.push(4);
        s1.pop();
        s1.peek();
        s1.isEmpty();
        s1.isFull();
    }
}

