
package leetcode.etc;
public class LeetCode02_AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next =new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next =new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode node = answer;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum %= 10;

            ListNode temp = new ListNode(sum);
            node.next = temp;
            node = node.next;
        }

        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            node.next = temp;

        }

        return answer.next;
    }
    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

