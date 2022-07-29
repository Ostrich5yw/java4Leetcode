package simpleDifficulty;

public class p141_GO {
//    func Do141(head *ListNode) bool {
//        if head == nil || head.Next == nil {
//            return false
//        }
//        for node := head; node != nil; node = node.Next {
//            node.Val = 1000000
//            if node.Next != nil && node.Next.Val == 1000000 {
//                return true
//            }
//        }
//        return false
//    }

    //思路二 快慢指针，快指针每次向后2位，慢指针向后1位，如果可以追上，说明有环
//    func hasCycle(head *ListNode) bool {
//        if head == nil || head.Next == nil {
//            return false
//        }
//        slow := head
//        fast := head.Next
//        for slow != fast {
//            if fast == nil || fast.Next == nil {
//                return false
//            }
//            slow = slow.Next
//            fast = fast.Next.Next
//        }
//        return true
//    }
}
