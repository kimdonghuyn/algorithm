class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int g = gcd(cur.val, cur.next.val);
            ListNode inserted = new ListNode(g, cur.next);
            cur.next = inserted;
            cur = inserted.next;
        }
        return head;
    }
}
