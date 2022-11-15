/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
*   Runtime : 0 ms
*   Memory : 41.3 MB
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode();
        ListNode newNode = resultNode;
        
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                newNode.next = list2;
                list2 = list2.next;
            } else {
                newNode.next = list1;
                list1 = list1.next;
            }
            newNode = newNode.next;
        }
        
        if(list1 != null) newNode.next = list1;
        else newNode.next = list2;
        
        return resultNode.next;
    }
}
