package leetcode.linkedlist;

public class LeetCode876_MiddleoftheLinkedList {

    /**
     * 아래는 [1,2,3,4,5,6,7,8,9,10] 이라는 긴 리스트에 대해 투 포인터 기법을 적용했을 때
     * 슬로우와 패스트 포인터의 움직임을 표로 나타낸 것입니다:
     *
     * 스텝   슬로우	패스트
     * 1	    1	    2
     * 2	    2	    4
     * 3	    3	    6
     * 4	    4	    8
     * 5	    5	    10
     * 6	    6	    끝
     * 투 포인터 기법에서는 슬로우 포인터가 한 칸씩 움직이고 패스트 포인터는 두 칸씩 움직입니다.
     * 따라서 패스트 포인터가 리스트의 끝에 도달했을 때, 슬로우 포인터는 중간 위치에 있게 됩니다.
     * 이 경우 리스트의 길이가 짝수이므로 두 중간 노드 중 두 번째 노드인 6을 반환하게 됩니다.
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
