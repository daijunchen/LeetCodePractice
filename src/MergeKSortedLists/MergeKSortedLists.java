package MergeKSortedLists;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        listNode3.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[4];
        lists[0] = null;
        lists[1] = listNode;
        lists[2] = listNode2;
        lists[3] = listNode3;

        ListNode result = mergeKLists(lists);

        System.out.println(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;

        while (length > 1){
            if (length % 2 == 0){
                for (int i = 0; i < (length / 2); i++) {
                    ListNode listNode = mergeChildList(lists[i], lists[length - i - 1]);
                    lists[i] = listNode;
                }
                length /= 2;
            }else {
                for (int i = 0; i < (length - 1) / 2; i++) {
                    ListNode listNode = mergeChildList(lists[i], lists[length - i - 1]);
                    lists[i] = listNode;
                }
                length = (length + 1) / 2;
            }
        }
        return lists[0];
    }

    public static ListNode mergeChildList(ListNode left,ListNode right){
        ListNode resultHead;
        resultHead = new ListNode(-1);
        ListNode tempNode = resultHead;

        while (left != null && right != null){
            boolean b = left.val < right.val;
            if (b) {
                tempNode.next = left;
                left = left.next;
            }else {
                tempNode.next = right;
                right = right.next;
            }
            tempNode = tempNode.next;
        }

        if (left != null){
            tempNode.next = left;
        }
        if (right != null){
            tempNode.next = right;
        }
        left = resultHead.next;
        return left;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
