public class LC002AddTwoNumbers {
    public static void main(String[] args) {
        int[] a1 = {9,9,9,9,9,9,9};
        int[] a2 = {9,9,9,9};
        ListNode n1 = convertToListNode(a1);
        ListNode n2 = convertToListNode(a2);
        
        ListNode res = addTwoNumbers(n1, n2);
        while(true) {
            System.out.println(res.val);
            if (res.next == null) break;
            res = res.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lastNode = null;
        ListNode firstNode = null;
        ListNode currentNode;
        int tens = 0;
        while(true) {
            if (l1 == null && l2 == null) {
                if (tens != 0) lastNode.next = new ListNode(tens);
                break;
            }
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int resVal = val1 + val2 + tens;
            if (resVal > 9) {
                resVal-=10;
                tens = 1;
            } else
                tens = 0;
            currentNode = new ListNode(resVal);
            if (lastNode != null) lastNode.next = currentNode; else firstNode = currentNode;
            lastNode = currentNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return firstNode;
    }
    
    
    public static ListNode convertToListNode(int[] arr) {
        ListNode lastNode = null;
        ListNode nextNode = null;
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (nextNode != null) {
                lastNode = new ListNode(arr[i], nextNode);
            } else {
                lastNode = new ListNode(arr[i]);
            }
            nextNode = lastNode;
        }
        return lastNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
