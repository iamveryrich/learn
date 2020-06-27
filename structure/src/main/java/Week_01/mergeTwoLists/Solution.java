package Week_01.mergeTwoLists;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


import org.junit.Test;


public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempNode1 = l1,tempNode2 = l2,currNode = new ListNode(0),newNode = new ListNode(0,currNode);

        while(true){
            if(tempNode1 == null && tempNode2 == null){
                break;
            }
            if(tempNode1 == null && tempNode2 != null){
                currNode.next = tempNode2;
                break;
            }
            if(tempNode1 != null && tempNode2 == null){
                currNode.next = tempNode1;
                break;
            }

            if(tempNode1.val > tempNode2.val){
                currNode.next = tempNode2;
                currNode = tempNode2;
                tempNode2 = tempNode2.next;
            }else{
                currNode.next = tempNode1;
                currNode = tempNode1;
                tempNode1 = tempNode1.next;
            }
        }
        return newNode.next.next;
    }

    @Test
    public void testResult(){
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode newNode = mergeTwoLists(node1,node2);
        System.out.println(newNode);
    }

    /*leetcode submit region begin(Prohibit modification and deletion)*/
// Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

