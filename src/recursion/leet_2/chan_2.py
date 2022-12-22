# https://leetcode.com/problems/add-two-numbers/
# memory usage: 13.8 MB, time usage: 65 ms
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    result = ListNode(0)
    result_head = result
    carry = 0
    while l1 is not None or l2 is not None or carry != 0:
        current_l1_val = l1.val if l1 else 0
        current_l2_val = l2.val if l2 else 0

        temp_sum = current_l1_val + current_l2_val + carry
        carry = temp_sum // 10

        temp_node = ListNode(temp_sum - carry * 10)
        result.next = temp_node
        result = temp_node

        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None

    return result_head.next


if __name__ == "__main__":
    l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    result_node = add_two_numbers(l1, l2)

    while result_node:
        print(result_node.val)
        result_node = result_node.next
