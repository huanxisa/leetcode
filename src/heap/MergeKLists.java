package heap;


public class MergeKLists {
    public ListNode solution(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null? l2: l1;

        return dummyHead.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}