
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



public class Main {
    
    
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode first = head;
        ListNode current = head;

        for(int i = 1; i < left; i++){
            current = head;
            head = head.next;
        }

        ListNode response = reverseFirstNNodesAndCoupleWithRemaining(head, right - left + 1);

        if(head == first){
            head = response;
            return head;
        }else {
            current.next = response;
            return first;
        }

    }

    private static ListNode reverseFirstNNodesAndCoupleWithRemaining(ListNode head, int nodes) {
        ListNode previous = null;
        ListNode current;
        ListNode next =null;
        ListNode first = head;

        for(int i = 0; i < nodes; i++){
            current = head;
            next = head.next;
            head.next = previous;
            head = next;
            previous = current;
        }
        first.next = next;

        return previous;
    }

}