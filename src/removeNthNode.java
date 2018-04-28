
public class removeNthNode {

    static class ListNode
    {
        ListNode next;
        int val;
        public ListNode(int val)
        {
            this.val = val;
        }
    }

    public void removeNode(ListNode node,int n)
    {
        ListNode prev =  null;
        while(n-- > 0)
        {
            if(node.next != null)
            {
                prev = node;
                node = node.next;
            }
        }
        prev.next = node.next;
    }

    public void display(ListNode node)
    {
        while(node != null)
        {
            System.out.print(node.val + "->" );
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        removeNthNode rn = new removeNthNode();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        rn.display(head);
        rn.removeNode(head,3);
        System.out.println("After Deletion");
        rn.display(head);
    }
}
