public class stackImpl {
    private int[] stack;
    private int top;
    private int maxSize;

    public stackImpl(int s)
    {
        maxSize = s;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x)
    {
        top++;
        stack[top] = x;
    }

    public int pop()
    {
        return stack[top--];
    }

    public int peek()
    {
        return stack[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return top == maxSize;
    }

    public void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        stackImpl si = new stackImpl(10);
        si.push(10);
        si.push(20);
        si.push(30);
        si.pop();
        si.display();
        //System.out.println(si.peek());
    }
}
