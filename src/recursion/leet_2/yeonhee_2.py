# https://leetcode.com/problems/add-two-numbers/
# Runtime
# 176 ms
# Memory
# 13.8 MB

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """ 
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # l1 : 2 -> 4 -> 9 
        # l2 : 5 -> 6 -> 4 -> 9 일 때,
        # l1, l2 노드를 순회하면서 값들을 list에 넣어준다
        # l1, l2 리스트를 reverse함
        # 942 +  9465 => 나오는 값 그대로 list에 저장 후 
        # 링크드리스트 만들어서 return

        l1_list = []
        while l1 != None:
            l1_list.append(l1.val)
            l1 = l1.next
        l1_list.reverse()
        l1_to_num = int(''.join(str(s) for s in l1_list))

        l2_list = []
        while l2 != None:
            l2_list.append(l2.val)
            l2 = l2.next
        l2_list.reverse()
        l2_to_num = int(''.join(str(s) for s in l2_list))

        # 두 수 더하고 list에 하나씩 담는다
        result = l1_to_num + l2_to_num
        result_list = list(map(int, str(result)))

        # 뒤에서부터 담아야함
        head = ListNode(result_list.pop())
        for idx in range(len(result_list) -1 , -1, -1 ):
            next_node = ListNode(result_list[idx])
            tmp = head
            while tmp.next != None:
                tmp = tmp.next

            tmp.next = next_node
        
        return head

n3 = ListNode(9) 
n2 = ListNode(9, n3)
n1 = ListNode(9, n2)
n0 = ListNode(9, n1)
nc = ListNode(9, n0)
nb = ListNode(9, nc)
na = ListNode(9, nb)

n6 = ListNode(9) 
n5 = ListNode(9, n6)
n4= ListNode(9, n5)
nh= ListNode(9, n4)

testL9 = ListNode(9)
testL4 = ListNode(4, testL9)
testL2 = ListNode(2, testL4)

testR9 = ListNode(9)
testR4 = ListNode(4, testR9)
testR6 = ListNode(6, testR4)
testR5 = ListNode(5, testR6)

s = Solution()
result = s.addTwoNumbers(na, nh)
while result != None:
    print(result.val)
    result = result.next


result = s.addTwoNumbers(testL2, testR5)
while result != None:
    print(result.val)
    result = result.next
