package simpleDifficulty;

import dataStructure.ListNode;

public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while(A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
//        Set<ListNode> set = new HashSet<>();
//        while(headA != null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        while(headB != null){
//            if(set.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
    }
}
