class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public ListNode sortLinkedList(ListNode head) {
    if (head == null || head.next == null) {
        return head; // No need to sort an empty list or a list with one element.
    }

    ListNode zeroHead = new ListNode(0);
    ListNode oneHead = new ListNode(0);
    ListNode twoHead = new ListNode(0);

    ListNode zeroTail = zeroHead;
    ListNode oneTail = oneHead;
    ListNode twoTail = twoHead;

    ListNode current = head;

    // Partition the list into three separate lists based on the values.
    while (current != null) {
        if (current.val == 0) {
            zeroTail.next = current;
            zeroTail = current;
        } else if (current.val == 1) {
            oneTail.next = current;
            oneTail = current;
        } else {
            twoTail.next = current;
            twoTail = current;
        }
        current = current.next;
    }

    // Connect the three lists.
    zeroTail.next = oneHead.next;
    oneTail.next = twoHead.next;
    twoTail.next = null; // Mark the end of the sorted list.

    return zeroHead.next;
}
