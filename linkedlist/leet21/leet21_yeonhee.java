package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void ShowAll()
    {
        ListNode tmp = this;
        while(tmp != null)
        {
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
    }
 }
// 1ms, 43.8mb
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(null == list1)
            return list2;
        if(null == list2)
            return list1;
        ListNode head = new ListNode();
        ListNode tmp = head;
        while(list1 != null && list2 != null)
        {
            if(list1.val<=list2.val)
            {
                tmp.next = list1;
                list1 = list1.next;
            }
            else
            {
                tmp.next = list2;
                list2 = list2.next;
            }

            tmp = tmp.next;
        }

        if(list1 == null)
            tmp.next = list2;
        else
            tmp.next = list1;

        return head.next;
    }
}

public class leetcode_21 {
    public static void main(String[] args) {

        ListNode aList = new ListNode(5);
        ListNode bList = new ListNode(3, aList);
        ListNode cList = new ListNode(1, bList);
        //cList.ShowAll();
        ListNode dList = new ListNode(4);
        ListNode eList = new ListNode(2, dList);

        Solution s = new Solution();
        ListNode res = s.mergeTwoLists(cList, eList);
        res.ShowAll();

    }
}
