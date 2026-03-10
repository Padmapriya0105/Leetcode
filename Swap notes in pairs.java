class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. Dummy node acts as the 'prev' for the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 2. Ensure there are at least two nodes to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // 3. The actual swapping logic
            first.next = second.next; // First points to the start of next pair
            second.next = first;      // Second points back to First
            prev.next = second;       // Prev points to Second (new head of pair)

            // 4. Move prev two steps ahead for the next pair
            prev = first;
        }

        return dummy.next;
    }
}
