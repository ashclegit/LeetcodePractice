public class linkedListPalindrome {

    private static class ListNode
    {
        ListNode next;
        int val;
        ListNode(int val)
        {
            this.val = val;
        }
    }


    public boolean checkPalidrome(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow.next != null)
        {
            if(slow.val != fast.val)
            {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode slow)
    {
        ListNode cur = slow;
        ListNode prev = null;

        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        linkedListPalindrome lp = new linkedListPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
        System.out.println(lp.checkPalidrome(head));
    }

}
