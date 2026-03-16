/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    // Create a dummy node to act as the predecessor of the head
    let dummy = new ListNode(0);
    dummy.next = head;
    let prev = dummy;

    while (prev.next !== null && prev.next.next !== null) {
        // Identify the nodes to be swapped
        let first = prev.next;
        let second = prev.next.next;

        // Perform the swap by reassigning pointers
        first.next = second.next;
        second.next = first;
        prev.next = second;

        // Move the 'prev' pointer forward to the next pair
        prev = first;
    }

    return dummy.next;
};
