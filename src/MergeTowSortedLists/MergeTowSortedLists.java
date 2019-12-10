package MergeTowSortedLists;

public class MergeTowSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead;
        resultHead = new ListNode(-1);
        ListNode tempNode = resultHead;

        while (l1 != null && l2 != null){
            boolean b = l1.val < l2.val;
            if (b) {
                tempNode.next = l1;
                l1 = l1.next;
            }else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }

        if (l1 != null){
            tempNode.next = l1;
        }
        if (l2 != null){
            tempNode.next = l2;
        }

        return resultHead.next;
    }
}
