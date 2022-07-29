package MediumDifficulty;

public class p138_GO {
//    /**
//     * Definition for a Node.
//     * type Node struct {
//     *     Val int
//     *     Next *Node
//     *     Random *Node
//     * }
//     */
//    var keymap = make(map[*Node]*Node)
//
//    func recursionCopy(node *Node) *Node {
//        if node == nil {
//            return nil
//        }
//        newNode := new(Node)
//                (*newNode).Val = (*node).Val
//                (*newNode).Next = recursionCopy((*node).Next)
//        keymap[node] = newNode
//        return newNode
//    }
//    func Do138(head *Node) *Node {
//        if head == nil {
//            return nil
//        }
//        newhead := recursionCopy(head)			//先回溯完成next复制
//        // for k, v := range keymap{
//        //     fmt.Println(k, v)
//        // }
//        newNode := newhead
//        for node := head; node != nil; node = node.Next {  //配合哈希表完成Random复制
//            if node.Random != nil {
//                newNode.Random = keymap[node.Random]
//            } else {
//                newNode.Random = nil
//            }
//            newNode = newNode.Next
//        }
//        // for temp:=head;temp!=nil;temp=temp.Next{
//        //     fmt.Println(temp.Val)
//        // }
//        return newhead
//    }

}
