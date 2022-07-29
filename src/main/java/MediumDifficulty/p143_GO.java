package MediumDifficulty;

public class p143_GO {
//    package leetcodeProject
//
//import "fmt"
//
//    func main(){
//        fmt.Print()
//    }
//
//    func reorderList(head *ListNode)  {
//        if head != nil && head.Next != nil && head.Next.Next != nil {
//            var len int = 0
//            for temp := head; temp != nil; temp = temp.Next {
//                fmt.Println(temp.Val)
//            }
//            record := make(map[int]*ListNode)
//            for temp := head; temp != nil; temp = temp.Next {
//                len++
//                record[len] = temp
//            }
//            temp := head
//            pos := 1
//            for pos = 1;pos <= len/2; pos++ {
//                temp = record[pos]
//                temp.Next = record[len-pos+1]
//                temp.Next.Next = record[pos+1]
//            }
//            if len % 2 == 0 {
//                temp.Next.Next = nil
//            } else {
//                temp.Next.Next = record[pos]
//                temp.Next.Next.Next = nil
//            }
//            for temp := head; temp != nil; temp = temp.Next {
//                fmt.Println(temp.Val)
//            }
//        }
//    }



}
