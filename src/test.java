
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class test {
    public static void main(String[] args) {
        test t = new test();
        int[] arr = new int[]{4 ,3, 2, 5, 2};
        ListNode head = new ListNode(1);
        ListNode list = head;
        for(int i = 0;i < arr.length;i ++){
            ListNode temp = new ListNode(arr[i]);
            list.next = temp;
            list = temp;
        }
        System.out.println(t.partition(head, 3));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode tt = head;
        return head;
    }
}