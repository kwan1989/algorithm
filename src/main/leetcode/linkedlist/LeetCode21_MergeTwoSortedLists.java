package leetcode.linkedlist;

public class LeetCode21_MergeTwoSortedLists {


//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    /*
        이 코드는 LeetCode의 문제 21, "Merge Two Sorted Lists"을 해결하기 위한 Java 솔루션입니다. 이 문제는 두 개의 정렬된 연결 리스트를 입력으로 받아, 이들을 하나의 정렬된 연결 리스트로 병합하는 것이 목표입니다. 코드는 다음과 같은 방식으로 작동합니다:

        1. **임시 머리 노드(`preHead`)**: 먼저, `-1` 값을 가지는 임시 머리 노드(`preHead`)를 생성합니다. 이 노드는 결과 연결 리스트의 실제 시작 노드를 가리키는 역할을 합니다. 최종 결과를 반환할 때는 이 임시 머리 노드의 다음 노드(`preHead.next`)를 반환하게 됩니다.

        2. **병합 과정**: 두 입력 리스트(`list1`과 `list2`)를 순회하면서 각 노드의 값을 비교합니다. 더 작은 값을 가진 노드를 현재 노드(`curr`)의 다음 노드로 연결하고, 해당 리스트를 한 칸 앞으로 이동시킵니다(`list1` 또는 `list2`의 `next`로 이동). 이 과정을 `list1`과 `list2` 중 하나라도 `null`이 될 때까지 반복합니다.

        3. **남은 노드 처리**: `list1`이나 `list2` 중 하나가 먼저 끝에 도달하면, 나머지 리스트의 남은 부분을 현재 노드(`curr`)의 다음 노드로 연결합니다. 이는 `list1` 또는 `list2` 중 하나가 `null`일 때, `curr.next`에 나머지 리스트를 연결함으로써 이루어집니다.

        4. **결과 반환**: `preHead`는 임시로 생성된 노드이므로, 실제 병합된 리스트는 `preHead.next`에서 시작합니다. 따라서 `preHead.next`를 반환하여 병합된 리스트를 제공합니다.

        이 코드의 핵심은 두 정렬된 리스트를 순회하면서 각 단계에서 작은 값을 선택하여 새로운 리스트에 추가하는 것입니다. 이 방식으로 두 리스트를 완전히 순회하고 난 후, 병합된 정렬된 리스트를 얻을 수 있습니다.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            /*
            `curr = curr.next;` 이 코드는 현재 노드(`curr`)를 현재 노드의 다음 노드(`curr.next`)로 업데이트하는 것을 의미합니다. 이는 연결 리스트를 다룰 때 자주 사용되는 기법 중 하나입니다.
            이 코드는 주로 연결 리스트를 순회하거나, 새로운 노드를 추가할 때 현재 작업 중인 노드의 위치를 업데이트하기 위해 사용됩니다. 연결 리스트에서 각 노드는 다음 노드를 가리키는 참조(`next`)를 가지고 있으며, `curr.next`는 현재 노드의 다음 노드를 가리킵니다. 따라서, `curr = curr.next;`를 실행하면 `curr`는 리스트의 다음 노드로 이동하게 됩니다.

            위의 코드 컨텍스트에서 볼 때:
            1. `curr`는 합병된 연결 리스트에서 현재 작업 중인 노드를 가리킵니다.
            2. 두 연결 리스트 중에서 값이 더 작은 노드를 `curr.next`로 설정함으로써, 그 노드를 합병된 리스트에 추가합니다.
            3. `curr = curr.next;`를 실행하여 `curr`를 방금 추가한 노드로 업데이트합니다. 이로써 다음 반복에서 또 다른 노드를 추가할 때, 올바른 위치에 추가할 수 있게 됩니다.

            이 과정을 통해 두 연결 리스트를 순차적으로 합병하면서, `curr`를 사용하여 합병 리스트의 현재 위치를 계속 추적하게 됩니다.
             */
            curr = curr.next;
        }

        if (list1 == null){
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return preHead.next;
    }
}
