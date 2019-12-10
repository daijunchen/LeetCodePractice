package RemoveNthNodeFromEndofList;


public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 0; i < 1; i++) {
            temp.next = new ListNode(2);
            temp = temp.next;
        }
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int i = removeNode(head, n);
        switch (i){
            case -1:
                return head;
            case 1:
                return null;
            default:
                return head.next;
        }
    }

    static int removeNode(ListNode node,int n){
        if (node.next != null){
            int i = removeNode(node.next, n);
            if (i == -1) {
                return -1;
            }
            if (n == i){
                node.next = node.next.next;
                return -1;
            }
            return i + 1;
        }else {
            return 1;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


