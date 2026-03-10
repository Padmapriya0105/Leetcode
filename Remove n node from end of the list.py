# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # 1. Create a dummy node pointing to the head
        dummy = ListNode(0, head)
        fast = slow = dummy
        
        # 2. Advance the fast pointer by n steps
        for _ in range(n):
            fast = fast.next
            
        # 3. Move both pointers until fast reaches the last node
        while fast.next:
            fast = fast.next
            slow = slow.next
            
        # 4. Skip the target node
        slow.next = slow.next.next
        
        # 5. Return the new head (dummy.next handles head removal automatically)
        return dummy.next
